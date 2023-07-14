package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {
WebDriver driver;
@Before
public void init() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Manju\\Eclipse\\Selenium\\session4\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	@Test
	public void testMouseHover() throws InterruptedException {
		
	By computerAccField= (By.xpath("//span[text()='Computers & Accessories']"));	
	By monitorField= (By.xpath("//button [text()='Monitors']"));
	By viewAllMonitorsField= (By.xpath("//a[text()='View All Monitors']"));

	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(computerAccField)).build().perform();
	action.moveToElement(driver.findElement(monitorField)).build().perform();
	driver.findElement(viewAllMonitorsField).click();
	
	
	
	}
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(9000);
		driver.close();
		driver.quit();
		
		
		
	}
	
}
