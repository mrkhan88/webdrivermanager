import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click(); //Click on Try on.
		
		String alerttext = driver.switchTo().alert().getText();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(3000);
		
		System.out.println("The Text alert is :"+alerttext);
		alert1.accept();
//		driver.switchTo().alert().accept();
		
//		now switch back to main html page
//		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[@id=\"tryhome\"]")).click();
		
		
	
		
	}

}
