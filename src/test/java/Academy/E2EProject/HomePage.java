package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.landingPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	private static Logger Log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		Log.info("Step 1: Initialize Driver");
		driver=initializeDriver();
		

	}
	
	
	@Test(dataProvider ="getData")
	public void basePageNavigiation(String username, String password) throws IOException
	{
		Log.info("Step 2: Login-In using the credentials");
		driver.get(prop.getProperty("url"));
		landingPage l = new landingPage(driver);
		l.getUsername().sendKeys(username);
		l.getPassword().sendKeys(password);
		l.getLogin().click();
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{	
		Object[][] data=new Object[1][2];
		data[0][0]= "jpromo.5";
		data[0][1]= "June122012.";
		
		/*data[1][0]= "tae";
		data[1][1]= "tae";*/
		return data;
		
	
	}
	
	@AfterTest
	public void tearDown()
	{
		Log.info("Step 3: Close all ");
		driver.close();
	}
	

}
