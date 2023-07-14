package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnScroll {
WebDriver driver;
public void init() {
	// Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://www.techfios.com/billing/?ng=admin/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void learnScroll() {
	
	
}
	
	
	
	
	
	
}
