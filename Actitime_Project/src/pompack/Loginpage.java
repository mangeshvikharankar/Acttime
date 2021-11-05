package pompack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage 
{
	private WebDriver driver;                       //declaring global WebDriver
	private WebDriverWait wait;                     // declaring global WebDriverWait for explicit wait
	
    @ FindBy (xpath = "//input[@name='username']")
    private WebElement Username;
    
    @FindBy (xpath = "//input[@name='pwd']")
    private WebElement Password;
	 
	@FindBy (xpath = " //a[@id='loginButton']")
	private WebElement login;
	
	@FindBy (xpath= "//a[@class='logout']")
	private WebElement logout;
	
	public Loginpage(WebDriver driver)             //driver(constructor driver) = driver = new Chromedriver
	{
		this.driver =driver;                      //global WebDriver = local WebDriver (Constructor WebDriver).. to avoid null pointer exception
		wait=new WebDriverWait (driver, 10);
		PageFactory.initElements(driver, this);	
	}
	
	public void loginactitime() 
	{
		wait.until(ExpectedConditions.visibilityOf(Password));
		Username.sendKeys("admin");
		Password.sendKeys("manager");
		login.click();
	}
	public void logout() 
	{
		logout.click();
	}
	
	
}
