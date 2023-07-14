package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LearnKeyboardEvent {
WebDriver driver;
By userNameField = By.xpath("//input[@id='username']");
By passwordField = By.xpath("//input[@id='password']");
By signinButtonField = By.xpath("//button[@name='login']");
@Before
public void init() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Manju\\Eclipse\\Selenium\\session4\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test
public void keyboardEventLogin() throws InterruptedException {
	
	driver.findElement(userNameField).sendKeys("demo@techfios.com");
	driver.findElement(passwordField).sendKeys("abc123");
	//driver.findElement(signinButtonField).click();
	Thread.sleep(5000);
	Actions action=new Actions(driver);//for enter key to perform enter using the code no1
	action.sendKeys(Keys.ENTER).build().perform();//for enter key to perform enter using the code no2


	
	
	
}
@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}



