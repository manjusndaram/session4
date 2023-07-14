package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnDropdown {
	WebDriver driver;
	By userNameField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	By signinButtonField = By.xpath("//button[@name='login']");
	By dashBoardHeaderField = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By customerMenuField = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
	By addCustomerMenuField = By.xpath("//ul[@id='side-menu']/li[3]/ul/li[1]/a");
	By addCustomerHeaderField = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]");
	By fullNameField = By.xpath("//*[@id=\"account\"]");
	By companyDropDownFeild = By.xpath("//select[@id='cid']");

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Manju\\Eclipse\\Selenium\\session4\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void login() throws InterruptedException {
		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		driver.findElement(passwordField).sendKeys("abc123");
		driver.findElement(signinButtonField).click();
		driver.findElement(dashBoardHeaderField).click();
		// for getting the title
		String pageTitle = driver.getTitle();// dashboard title
		String dashboardHeaderText = driver.findElement(dashBoardHeaderField).getText();
		System.out.println(driver.findElement(dashBoardHeaderField).getText());
		System.out.println(driver.findElement(dashBoardHeaderField));
		Assert.assertEquals("Dashboard page not found", "Dashboard", dashboardHeaderText);
		Assert.assertEquals("Dashboard-iBilling page title not found", "Dashboard- iBilling", pageTitle);
		Thread.sleep(2000);
		driver.findElement(customerMenuField).click();
		driver.findElement(addCustomerMenuField).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(customerMenuField));
		// another way to do the above wait
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(customerMenuField)));
		Assert.assertEquals("add customer field not found", "Add Customer",
				driver.findElement(addCustomerMenuField).getText());
		driver.findElement(fullNameField).sendKeys("selenium");
		Assert.assertTrue("fullName field not found", driver.findElement(fullNameField).isDisplayed());
		Select sel = new Select(driver.findElement(companyDropDownFeild));
		sel.selectByVisibleText("Techfios");

	}

	

	/*
	 * @After public void tearDown() { driver.close(); driver.quit();
	 * 
	 * }
	 */

}
