package Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        
        WebDriver driver = new FirefoxDriver();


        driver.get("https://alchemy.hguy.co/jobs");

      
        String headingText = driver.findElement(By.xpath("//h2")).getText();

   
        System.out.println("Second heading: " + headingText);

  
        if (headingText.equals("Quia quis non")) {
            System.out.println("Heading matches.");
            driver.quit(); 
        } else {
            System.out.println("Heading does not match.");
        }
    }
}
