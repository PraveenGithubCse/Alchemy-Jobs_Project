package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class A2 {
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
	// Verify the website heading
	public void verifyHeading()
	{
		String website_heading = driver.findElement(By.cssSelector("h1.entry-title")).getText();
		assertEquals(website_heading, "Welcome to Alchemy Jobs");
		driver.quit();
	}

	

}
