package alchemyJobs;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Sample {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp()
	{
		driver = new EdgeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://alchemy.hguy.co/jobs/");
		
	}
	// Verify website title
	@Test(priority = 1)
	public void verifyTitle()
	{
	  assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application");
	  driver.quit();
	}
	
	
	

}

