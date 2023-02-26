package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\WPC\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\data");
		
		prop.load(fis);
		
		//mvn test -Dbrowser=chrome
		String browserName = prop.getProperty("browser");
		//String browserName = System.getProperty("browser");
		
		//Test
		System.out.println(browserName);
		
		if(browserName.equals("chrome") )
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\WPC\\Documents\\ChromeDriver\\ChromeDriver.exe"); // Setting system properties of ChromeDriver
			driver = new ChromeDriver(); //Creating an object of ChromeDriver
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\WPC\\Documents\\GeckoDiriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			// Defining System Property for the IEDriver 
			System.setProperty("webdriver.ie.driver", "C:\\Users\\WPC\\Documents\\IEDriver\\IEDriverServer.exe"); 

			// Instantiate a IEDriver class. 
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Error");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver ) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\report\\"+ testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	

}
