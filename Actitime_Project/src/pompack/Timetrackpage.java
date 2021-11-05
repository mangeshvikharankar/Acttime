package pompack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Timetrackpage 
{
	private WebDriver driver;                       //declaring global WebDriver
	
	@FindBy(xpath = "(//div[@class='label'])[1]")
	private WebElement Timetrack;
	
	@FindBy (xpath = "(//div[@class='label'])[2]")
	private WebElement Tasks;
	
	@FindBy (xpath = "(//div[@class='label'])[3]")
	private WebElement reports;
	
	@FindBy (xpath = "(//div[@class='label'])[4]")
	private WebElement users;
	
	@FindBy (xpath = "(//div[@class='label'])[5]")
	private WebElement workschedule;

	
	public Timetrackpage(WebDriver driver)         //driver(constructor driver) = driver = new Chromedrive
	{
		this.driver =driver;                      //global WebDriver = local WebDriver (Constructor WebDriver).. to avoid null pointer exception
		PageFactory.initElements(driver, this);
	}
	
	public void Taskspage()
	{
		Tasks.click();
	}
	
	public void Reportspage()
	{
		reports.click();
	}
	
	public void userspage()
	{
		users.click();
	}
	
	public void workschedulepage()
	{
		workschedule.click();
	}
	
	
}
