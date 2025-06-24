package alchemyJobs;

//import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver = new FirefoxDriver();
	@BeforeClass
	public void setUp()
	{
		driver.get("https://alchemy.hguy.co/jobs/");
		
	}
	// Verify website title
	@Test(priority = 1)
	public void displayImageSrc()
	{
		WebElement img=driver.findElement(By.cssSelector(".attachment-large.size-large.wp-post-image"));
		String imgUrl = img.getAttribute("src");
		System.out.println("Image URL: " + imgUrl);
		Reporter.log(imgUrl);
		driver.quit();
	}
}
