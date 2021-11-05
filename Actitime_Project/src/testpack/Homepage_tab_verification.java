package testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompack.Timetrackpage;
import pompack.Loginpage;
//user story :-
//1. Verify all the links on tabes provided on homepage.
public class Homepage_tab_verification 
{
	
	private WebDriver driver;
	private Loginpage loginpage;
	private Timetrackpage Verify;
	
	@BeforeClass 
	public void setdriver()
	{
		System.setProperty("webdriver.chrome.driver","F:\\VELOCITY\\Software\\Selenium\\new\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1/login.do");
	}
	
	@BeforeMethod 
	public void login()
	{
		loginpage= new Loginpage(driver);
		loginpage.loginactitime();
		Verify = new Timetrackpage(driver);
	}
	
	@Test(priority=1 )
	public void taskspageverification()
	{
		Verify.Taskspage();
		String url =driver.getCurrentUrl();
		System.out.println(url);
		
		if (url.equals("http://127.0.0.1/tasks/otasklist.do"))
		{
			System.out.println("Test case of Taskspage is Pass");
		}
		else
		{
			System.out.println("Test case of Taskspage is Fail");
		}
	}
	
	@Test (priority=5)
	public void reportspageverification()
	{
		Verify.Reportspage();
		
		if (driver.getCurrentUrl().equals("http://127.0.0.1/reports/reports.do"))
		{
			System.out.println("Test case of Reportspage is Pass");
		}
		else
		{
			System.out.println("Test case of Reportspage is Fail");
		}
	}
	
	@Test(priority=2)
	public void userspageverification()
	{
		Verify.userspage();
		if (driver.getCurrentUrl().equals("http://127.0.0.1/administration/userlist.do"))
		{
			System.out.println("Test case of userspage is Pass");
		}
		else
		{
			System.out.println("Test case of userspage is Fail");
		}
		
	}
	
	@Test (priority=3)
	public void workschedulepageverification()
	{
		Verify.workschedulepage();
		if (driver.getCurrentUrl().equals("http://127.0.0.1/administration/workingdays.do"))
		{
			System.out.println("Test case of workschedulepage is Pass");
		}
		else
		{
			System.out.println("Test case of workschedulepage is Fail");
		}
	}
	
	@AfterMethod void logout()
	{
		loginpage.logout();

	}
	
	@AfterClass void close ()
	{
		driver.close();
	}

}

