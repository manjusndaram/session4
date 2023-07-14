package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnIFrame {
	WebDriver driver;
	@Before
public void init() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Manju\\Eclipse\\Selenium\\session4\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}
	@Test
	public void testIFrame() {
		driver.switchTo().frame("packageListFrame");//driver goes inside the frame
		//driver.findElement(By.xpath("/html/body/div[2]/ul/li[2]/a"));
		driver.findElement(By.xpath("//a[contains(text(),'java.awt')]")).click();//
		
		
	}
	
	
	
}
