package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	WebDriver driver ;
	
	public LoginPage(WebDriver driver) {
	
	 this.driver =driver ;
	  PageFactory.initElements(this.driver,this);
	
	}
 

@FindBy(xpath="//input[@id='username']")
WebElement Usernametxt;

@FindBy(xpath="//input[@id='password']")
WebElement  passwordtxt; 

@FindBy(xpath="//button[contains(@class,'css-177pwqq')]")
WebElement  LoginBtn; 








public void  EnterUsername()
{
	Usernametxt.sendKeys("Admin");
}
public void  EnterPassword()
{
	passwordtxt.sendKeys("Admin");
}
public void EnterLoginBtn() {
	LoginBtn.click();
	 }
}

