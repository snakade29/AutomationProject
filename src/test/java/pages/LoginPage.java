package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage  {
	WebDriver driver ;
	
	public LoginPage(WebDriver driver) {
	  super(driver);
	     }
 

@FindBy(xpath="//input[@id='username']")
WebElement Usernametxt;

@FindBy(xpath="//input[@id='password']")
WebElement  passwordtxt; 

@FindBy(xpath="//button[contains(@class,'css-177pwqq')]")
WebElement  LoginBtn; 








public void  EnterUsername(String username)
{
	Usernametxt.sendKeys(username);
}
public void  EnterPassword(String password)
{
	passwordtxt.sendKeys(password);
}
public void EnterLoginBtn() {
	LoginBtn.click();
	 }
}

