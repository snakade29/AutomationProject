package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Testcases.BaseTestClass;



 
public class Listener implements ITestListener{
	
	 

	
	
	
	   	
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub	
		   System.out.println("Test Finished");
	        		
	    }		

	   
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	    	System.out.println("Test  Started");
    				
	    }		

	    
	    
	    public void onTestFailure(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	    	//Convert web driver object to TakeScreenshot
	    	TakesScreenshot scrShot =((TakesScreenshot)BaseTestClass.driver);
	    	//Call getScreenshotAs method to create image file
	    	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	    	//Move image file to new destination  
	    	 String now = LocalDateTime.now().toString();
	    	String Filename = now;
	    	File DestFile=new File( System.getProperty("user.dir")+"/src/test/resources/"+Filename+".png");
	    	//Copy file at destination
	    	try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	    }		

	  
	    public void onTestSkipped(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	    	String Name = arg0.getName();
	    	System.out.println("Sucessfully executed" + Name);		
	    }		

	   
	   		
 	
	    public void onTestSuccess(ITestResult arg0) {					
	        // TODO Auto-generated method stub		
	          String Name = arg0.getName();
	    	System.out.println("Sucessfully executed" + Name);
	        		
	    }		
}
