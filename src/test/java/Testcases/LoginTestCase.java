package Testcases;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTestCase extends BaseTestClass {
	
	@Test 
	public void Login()
	{
	 
    
	HomePage homepage = new HomePage(driver);
	 log.info("We are on home page ") ;
	homepage.ClickonLoginBtn();
	LoginPage loginPage = new LoginPage(driver);
	 log.info("We are on Login page ") ;
	 loginPage.EnterUsername();
	 loginPage.EnterPassword();
	 loginPage.EnterLoginBtn();
	
	}
	

}
