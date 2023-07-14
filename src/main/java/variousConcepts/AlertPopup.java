package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup {
	
	WebDriver driver;
	@Before
	
	public void init() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Manju\\Eclipse\\Selenium\\session4\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}
	@Test
	//http://mail.redfill.com/ cgi-bin//login.cgi
	public void testAleart() throws InterruptedException {
	driver.findElement(By.xpath("//input[@name='proceed']")).click();//click on the signin button	
	//the popup will stay for the given time
	String alertMsg=driver.switchTo().alert().getText();//get Text method returns the string so we are converting everthing to string
	System.out.println(alertMsg);
	driver.switchTo().alert().accept();//if you do .accept first popup will go away and it can't do gettext.
	Thread.sleep(2000);	
	}
	
	
	
	
	

}
