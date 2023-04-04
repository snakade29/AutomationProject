package Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestData.DataProviderclass;
import objects.logindetails;
import pages.HomePage;
import pages.LoginPage;
import utilities.Listener;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Listeners(Listener.class)
public class LoginTestCase extends BaseTestClass {
	
	@Ignore
	@Test (dataProvider = "dp",  dataProviderClass  = DataProviderclass.class)
	public void Login(String username,String password)
	{
	 
    
	HomePage homepage = new HomePage(driver);
	 log.info("We are on home page ") ;
	homepage.ClickonLoginBtn();
	LoginPage loginPage = new LoginPage(driver);
	 log.info("We are on Login page ") ;
	 loginPage.EnterUsername(username);
	 loginPage.EnterPassword(password);
	 loginPage.EnterLoginBtn();
	 log.info("Login Succesfull");
	 
	 System.out.println( driver.getTitle());
	 
  try{
	  String Actual= driver.findElement(By.xpath("//p[text()='Admin1']")).getText();
	 
  }
  catch(Exception e){
	  
	  
	  Assert.assertTrue(false);
	  
  }
	 Assert.assertTrue(true);
	 
	
	}
	
	
	
	@Test
	public void Login1( ) throws StreamReadException, DatabindException, IOException
	{
		 

		// ...

       ObjectMapper objectMapper = new ObjectMapper();
	 File file  = new File("C:/Users/LENOVO/eclipse-workspace/Automationproject/src/test/resources/username.json");
	 InputStream input = new FileInputStream(file); 
	 logindetails loginobj    = objectMapper.readValue(input, logindetails.class);
    
	HomePage homepage = new HomePage(driver);
	 log.info("We are on home page ") ;
	homepage.ClickonLoginBtn();
	LoginPage loginPage = new LoginPage(driver);
	 log.info("We are on Login page ") ;
	 loginPage.EnterUsername(loginobj.getUsername());
	 loginPage.EnterPassword(loginobj.getPassword());
	 loginPage.EnterLoginBtn();
	 log.info("Login Succesfull");
	 
	 System.out.println( driver.getTitle());
	 
  try{
	  String Actual= driver.findElement(By.xpath("//p[text()='Admin1']")).getText();
	 
  }
  catch(Exception e){
	  
	  
	  Assert.assertTrue(false);
	  
  }
	 Assert.assertTrue(true);
	
	}
	
	

}
