package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyLogin {
	WebDriver driver;
    WebDriverWait wait;
    String jobTitle = "Selenium Automation";  // Made global to reuse

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.manage().window().maximize();
    }
    @Test
    public void verifyLogin() {
    	driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='adminmenuwrap']//div[text()='Dashboard']")));
        Assert.assertTrue(dashboard.isDisplayed());
    }
    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
}

