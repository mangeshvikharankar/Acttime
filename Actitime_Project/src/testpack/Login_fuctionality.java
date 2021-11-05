package testpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompack.Loginpage;
import pompack.Timetrackpage;

//user story:- verify login functionality.

public class Login_fuctionality 
{
	private WebDriver driver;
	private Loginpage loginpage;
	
	@BeforeClass 
	public void setdriver()
	{
		System.setProperty("webdriver.chrome.driver","F:\\VELOCITY\\Software\\Selenium\\new\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1/login.do");
	}
	
	@BeforeMethod 
	public void beforemethod()
	{
		loginpage= new Loginpage(driver);
	}
	
	@Test 
	public void test1() throws InterruptedException
	{
		loginpage.loginactitime();
		Thread.sleep(2000);
	}
	
	
	@AfterMethod 
	public void aftermethod()
	{
		loginpage.logout();
	
	}
	
	@AfterClass 
	public void close ()
	{
		driver.close();
	}

}
