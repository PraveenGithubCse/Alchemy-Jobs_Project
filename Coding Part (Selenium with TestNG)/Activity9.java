package alchemyJobs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {
	//WebDriver declaration
	WebDriver driver;
	//WebDriverWait declaration
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		//Initialize driver
		driver = new FirefoxDriver();
		//Initialize wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Open the page
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
	
	@Test(priority = 1)
	public void verifyTitleTest() {
		assertEquals(driver.getTitle(), "Log In ‹ Alchemy Jobs — WordPress");
	}
	
	@Test(priority = 2)
	public void login() {
//		Username: root
//		Password: pa$$w0rd
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test(priority = 3)
	public void checkLoggedIn() {
		assertEquals(driver.getTitle(), "Dashboard ‹ Alchemy Jobs — WordPress");
	}
	
	//Locate the left hand menu and click the menu item that says “Job Listings”.
	@Test(priority = 4)
	public void clickJobListings() {
		driver.findElement(By.id("menu-posts-job_listing")).click();
		assertEquals(driver.getTitle(), "Jobs ‹ Alchemy Jobs — WordPress");
	}
	
	//Locate the “Add New” button and click it.
	@Test(priority = 5)
	public void clickNew() {
		driver.findElement(By.linkText("Add New")).click();
		assertEquals(driver.getTitle(), "Add Job ‹ Alchemy Jobs — WordPress");
		driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
	}
	
	//add all the details and click publish
	@Test(priority = 6)
	public void fillDetails() {
		driver.findElement(By.id("post-title-0")).sendKeys("QE Full Stack");
		
		//scroll till company website textbox is visible
		WebElement element = driver.findElement(By.id("_company_website"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		//enter visible details
		driver.findElement(By.id("_job_location")).sendKeys("Kochi");
		driver.findElement(By.id("_application")).clear();
		driver.findElement(By.id("_application")).sendKeys("test@example.com");
		driver.findElement(By.id("_company_name")).sendKeys("MyCompany");
		driver.findElement(By.id("_company_website")).sendKeys("www.myCompany.com");

		//scroll till company expiry date is visible
		WebElement expiry = driver.findElement(By.id("_job_expires"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expiry);
		
		//fill rest of the details
		driver.findElement(By.id("_company_tagline")).sendKeys("Innovating Today. Empowering Tomorrow.");
		driver.findElement(By.id("_company_twitter")).sendKeys("@mycomp");
		driver.findElement(By.id("_company_video")).sendKeys("https://www.youtube.com/watch?v=dQw4w9WgXcQ\r\n");
		driver.findElement(By.id("_job_expires")).sendKeys("2025-08-16");
		
		//click publish
		driver.findElement(By.xpath("//button[text()='Publish…']")).click();
		//click publish again
		driver.findElement(By.xpath("//button[text()='Publish']")).click();
		
	}
	
	@Test(priority = 7)
	public void checkJob() {
		driver.get("https://alchemy.hguy.co/jobs/wp-admin/edit.php?post_type=job_listing");
		WebElement job = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/div/a"));
		job.click();
		
		//start checking the values
		assertEquals(driver.findElement(By.id("post-title-0")).getText(), "QE Full Stack");
		
		//scroll till company website textbox is visible
		WebElement element = driver.findElement(By.id("_job_expires"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				
		//check more values
		assertEquals(driver.findElement(By.id("_job_location")).getAttribute("value"), "Kochi");
		assertEquals(driver.findElement(By.id("_company_name")).getAttribute("value"), "MyCompany");
		assertEquals(driver.findElement(By.id("_application")).getAttribute("value"), "test@example.com");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit(); //browser will close even if there were errors
	}
}
