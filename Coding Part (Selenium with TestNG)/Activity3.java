package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
public static void main(String[] args) {


	
	WebDriver driver=new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/jobs/");
	 WebElement img=driver.findElement(By.cssSelector(".attachment-large.size-large.wp-post-image"));
	String imgUrl = img.getAttribute("src");
	System.out.println("Image URL: " + imgUrl);
	driver.close();
}
	
}
