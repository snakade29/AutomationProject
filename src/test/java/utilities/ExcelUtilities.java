package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

 

public class ExcelUtilities {

	 
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static XSSFCellStyle style;
		
		public static int getRowCount(String xlfile,String xlsheet) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			int rowcount=ws.getLastRowNum();
			wb.close();
			fi.close();
			return rowcount;		
		}
		
		
		public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			int cellcount=row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
		}
		
		public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			cell=row.getCell(colnum);
			String data;
			try 
			{
				data=cell.getStringCellValue();
			} catch (Exception e) 
			{
				data="";
			}
			wb.close();
			fi.close();
			return data;
		}
		
		public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			fo=new FileOutputStream(xlfile);
			wb.write(fo);		
			wb.close();
			fi.close();
			fo.close();
		}
		
		
		public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

			   String[][] tabArray = null;

			   try {

				   fi=new FileInputStream(FilePath );
					wb=new XSSFWorkbook(fi);
					ws=wb.getSheet(SheetName);
					row=ws.getRow(0);

			 

				  

				   int totalRows = ws.getLastRowNum();

				   // you can write a function as well to get Column count
				     
			        int cellcount=row.getLastCellNum();

				   int  totalcells=  cellcount;

				   tabArray=new String[totalRows][totalcells];
                        
				   
           String value ;
				   for(int r=1;r<=totalRows;r++)
					{
						XSSFRow currentRow=ws.getRow(r);
								
						for(int c=0;c<totalcells;c++)
						{
							//XSSFCell cell=currentRow.getCell(c);
							//String value=cell.toString();
//							String value=currentRow.getCell(c).toString();
							 XSSFCell Cell = null;
							 try {
					                Cell = currentRow .getCell( c);
					            } catch (NullPointerException npe) {
					                value = " ";
					            }
					            if (Cell == null) {
					                value = " ";
					            } else {
					                 value = Cell.getStringCellValue();
					            }
					  
							 
							
							System.out.print(value+"      ");
							tabArray[r-1][c]=value ;
							
							
						}
						System.out.println();
					}
			   }
				catch (FileNotFoundException e){

					System.out.println("Could not read the Excel sheet");

					e.printStackTrace();

					}

				catch (IOException e){

					System.out.println("Could not read the Excel sheet");

					e.printStackTrace();

					}

				return(tabArray);

				
		
		
		
		}
}

		
			
	

	

