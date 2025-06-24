package project;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewJobListing {

    WebDriver driver;
    WebDriverWait wait;
    String jobTitle = "Selenium Automation";  // Made global to reuse

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void postJobButton() {
        driver.findElement(By.linkText("Post a Job")).click();
    }

    @Test(priority = 2)
    public void jobDetails() {
        String msg = driver.findElement(By.linkText("Sign in")).getText();
        if (msg.equals("Sign in")) {
            driver.findElement(By.linkText("Sign in")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-submit")));
            driver.findElement(By.id("user_login")).sendKeys("root");
            driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
            driver.findElement(By.id("wp-submit")).click();
        }

        driver.findElement(By.id("job_title")).sendKeys(jobTitle);

        // Select job type
        Select jobType = new Select(driver.findElement(By.id("job_type")));
        jobType.selectByVisibleText("Internship");

        // Switch to TinyMCE iframe and enter description
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("job_description_ifr")));
        WebElement editableBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
        String jobDescription = "This is the description about job the job given above";
        editableBody.clear();
        editableBody.sendKeys(jobDescription);
        driver.switchTo().defaultContent();

        // Enter application email
        WebElement mail = driver.findElement(By.id("application"));
        mail.clear();
        mail.sendKeys("example@gmail.com");

        // Submit job
        driver.findElement(By.name("submit_job")).click();

        // Confirm submission
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_preview_submit_button"))).click();
        String successMessage = driver.findElement(By.cssSelector("div.entry-content.clear")).getText();
        assertTrue(successMessage.contains("Job listed successfully"), "Job was not listed successfully.");
    }

    @Test(priority = 3)
    public void verifyJobListing() {
        // Navigate to Jobs page
        driver.findElement(By.linkText("Jobs")).click();

        // Wait until job listings are visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("job_listings")));

        // Find all job titles
//        List<WebElement> jobListings = driver.findElements(By.cssSelector("ul.job_listings > li.job_listing h3"));
        //List<WebElement> jobListings = driver.findElements(By.cssSelector("li.type-job_listing"));

        //ul = driver.find_element(By.CSS_SELECTOR,"ul.some_class")  # or tag name, e.g. "ul", or XPath
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='position']/h3")));
        WebElement w = driver.findElement(By.cssSelector("div.position>h3"));
        String newJobListed = w.getText();

        System.out.println(newJobListed);
        
        assertEquals(newJobListed, jobTitle);
        System.out.println(newJobListed);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
