package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	public WebDriver driver;
	
	By username= By.id("email");
	By password= By.name("pass");
	By login= By.name("login");
	By title=By.cssSelector("#reg_pages_msg > a");
	
	public landingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	


}
