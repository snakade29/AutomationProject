package Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {
	
	
	WebDriver driver ;
	Properties config ;
	 //Added logger
	
	public static Logger log = Logger.getLogger( BaseTestClass.class);
	
	@BeforeMethod
	public void setup() throws Exception {
		
	config = new Properties() ;
    File file = new File(System.getProperty("user.dir")+"/src/test/resources/config.properties") ;
	FileInputStream fileinput =  new FileInputStream(file);
	config.load(fileinput);
	String browser = config.getProperty("browsertype");
	 
	PropertyConfigurator.configure("Log4j.properties");//Added logger
	 
 
	if(browser.equalsIgnoreCase("chrome"))
	{
		 
		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--remote-allow-origins=*");
	     driver = new ChromeDriver(chromeOptions);
	     
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		driver =new FirefoxDriver() ;
	
	}
	String URL = config.getProperty("baseurl");
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
     
}
}
