package Academy.E2EProject;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.landingPage;
import resources.base;


public class validateTitle extends base {
	public WebDriver driver;
	private static Logger Log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		Log.info("Step 1: Initialize Driver");
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	
	@Test
	
	public void validatePage() throws IOException
	{
		Log.info("Step 2: Validate text");
		landingPage l = new landingPage(driver);
		
		Assert.assertEquals(l.getTitle().getText(), "Create a Pagesss");
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		Log.info("Step 3: Close all ");
		driver.close();
	}
	

}
