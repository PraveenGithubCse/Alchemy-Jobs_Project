package Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ApplyToAJob {
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
	  public void searchJobKeyword() {
		  //find and send keyword Banking
		  driver.findElement(By.name("search_keywords")).sendKeys("Banking");
	  }
	
	@Test (priority = 3)
	  public void clickingSearchJobs() {
		  //find and click the Search Job button
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  }
	
	@Test (priority = 4)
	  public void clickingOnJob() {
		  //find and click on the position
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='position']"))).click();
	  }
	
	@Test (priority = 5)
	  public void clickingApplyForJob() {
		  //find and click apply for job and printing the email
		  driver.findElement(By.cssSelector(".application_button")).click();
		  //wait for the email
		  WebElement w=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='job_application_email']")));
		  System.out.println(w.getText());
	  }
	
	@BeforeClass
	public void beforeClass() {
		//declare the driver
		driver=new FirefoxDriver();
	  
		//declare the wait
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  
		//opening the browser
		driver.get("https://alchemy.hguy.co/jobs");
  }

	@AfterClass
	public void afterClass() {
		//closes the browser
		driver.quit();
  }


}
