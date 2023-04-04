package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
   WebDriver driver ;
  public HomePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	  this.driver =driver ;
	  PageFactory.initElements(this.driver,this);
}  
  
   @FindBy(xpath="//button[text()='Login']")
	WebElement LoginBtn ;
  
 
  public void ClickonLoginBtn()
  {
	LoginBtn.click();  
  }
  
	
}
