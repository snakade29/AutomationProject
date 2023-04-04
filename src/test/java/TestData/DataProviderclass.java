package TestData;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtilities;

public class DataProviderclass {
	
	
	 @DataProvider(name = "dp",indices = {0,2,3})
	    public Object[][] getExcelData() throws Exception{

	         Object[][] testObjArray = ExcelUtilities.getTableArray( System.getProperty("user.dir")+"./src/test/java/TestData/TestData.xlsx","Sheet1");

	         return (testObjArray);

			}
	 
	 
	 public static void main(String[] args) throws Exception {
		 
		 
		 DataProviderclass obj = new  DataProviderclass();
		 
		 obj.getExcelData();
		 
		 
	}

}
