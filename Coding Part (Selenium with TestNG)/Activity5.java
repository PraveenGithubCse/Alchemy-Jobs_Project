package Project;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigationToAnotherPage {
	//initilaize driver
	  WebDriver driver;
	//initialize wait
	WebDriverWait wait;
	
  @Test (priority = 1)
  public void clickingJob() {
	  //find and click the job link
	  driver.findElement(By.linkText("Jobs")).click();
  }
  
  @Test (priority = 2)
  public void getJobPageTitle() {
	  //get page title
	  assertEquals(driver.getTitle(), "Jobs – Alchemy Jobs");
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  //declare the driver
	  driver=new FirefoxDriver();
	  
	  //declare the wait
	  wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  //opening the browser
	  driver.navigate().to("https://alchemy.hguy.co/jobs");
  }

  @AfterClass
  public void afterClass() {
	  //closes the browser
	  driver.quit();
  }

}
