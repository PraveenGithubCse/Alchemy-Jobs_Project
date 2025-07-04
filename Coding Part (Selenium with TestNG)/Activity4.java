package alchemyJobs;

import static org.testng.Assert.assertEquals;

//import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp()
	{
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://alchemy.hguy.co/jobs/");
		
	}
	@Test(priority = 1)
	public void verifyTitle()
	{
		String headingText = driver.findElement(By.xpath("//h2")).getText();
		assertEquals(headingText, "Quia quis non");
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
	}
}
