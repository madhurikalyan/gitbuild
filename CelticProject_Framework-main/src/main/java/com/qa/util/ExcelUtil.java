package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	private  FileInputStream fis = null;
	private    XSSFWorkbook workbook = null;
	private   XSSFSheet sheet = null;
	private XSSFCell cell = null;
	private Map<String, Integer> columns = new HashMap<>();
	private String cellvalue=null;

	
	 public ExcelUtil(String xlFilePath)
	    {
	    	try {
	        fis = new FileInputStream(xlFilePath);
	        workbook = new XSSFWorkbook(fis);
	    	} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	finally {
				try {
					if(workbook!= null) {
					workbook.close(); }
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	}
	    }
	    @SuppressWarnings("incomplete-switch")
		public  String getCellData(String SheetName,String ColumnName,int rownum) throws IOException  {
			try {
			 sheet = workbook.getSheet(SheetName);
			 //adding all the column header names to the map 'columns'
			 sheet.getRow(0).forEach(cell ->{
	                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
	            });
			 cell = sheet.getRow(rownum).getCell(columns.get(ColumnName));
			 switch (cell.getCellType()){
	            case STRING:
	            	cellvalue = cell.getStringCellValue();
	                break;
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell))
	                {
	                	cellvalue = String.valueOf(cell.getDateCellValue());
	                }
	                else
	                {
	                	cellvalue = String.valueOf((long)cell.getNumericCellValue());
	                }
	                break;
	            case BOOLEAN:
	            	cellvalue = Boolean.toString(cell.getBooleanCellValue());
	                break;
	            case BLANK:
	            	cellvalue = "";
	                break;
	        }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			 return cellvalue;
			
	}
	/*    public void setCellData(String sheetname, String ColumnName,int rownum,String text) throws Exception {
	    	try
	    	{
	    		System.out.print("Started SetCellData");
	    		 int col_Num = 0;
	    		fis = new FileInputStream(new File(ConfigReader.writeexcel()));
	    		System.out.print("Step1");
	    		workbookC = WorkbookFactory.create(fis);
	    		System.out.print("Step2");
	    		for (int i=0; i<workbookC.getNumberOfSheets(); i++) {
	    			System.out.print("Step"+i);
	    			bool=workbookC.getSheetName(i).toString().equalsIgnoreCase(sheetname);
	    			if(bool==true) {
	    				break;
	    			}
	    		}
	    		System.out.print("Step3");
	    		if(bool==false) {
	    			System.out.print("Step4");
	    			newSheet = workbookC.createSheet(sheetname);
	    		}
	    		else {
	    			System.out.print("Step5");
	    			newSheet =workbookC.getSheet(sheetname);
	    		}
	    		int rown= newSheet.getLastRowNum();
	    		System.out.print("Step6");
	   			 if(rown>=rownum) {
	   				System.out.print("Step7");
	   				rowC= newSheet.getRow(rownum);
	   			 }
	   			 else {
	   				System.out.print("Step8");
	   				rowC= newSheet.createRow(rownum);
	   			 }
	   			newSheet.getRow(0).forEach(cell0 ->{
		                columns.put(cell0.getStringCellValue(), cell0.getColumnIndex());
		            });
	   			System.out.print("getLastCellNum"+newSheet.getRow(0).getLastCellNum());
           for (int i = 0; i < newSheet.getRow(0).getLastCellNum()+1; i++) {
            	System.out.print("Step3"+i);
                if (newSheet.getRow(0).getCell(i).getStringCellValue().trim().equals(ColumnName))
                {
                	System.out.print("Step3"+i+"1");
                    col_Num = i;
                }
            }
	   			if(columns.containsKey(ColumnName)) {
	   				System.out.print("ColumnName"+ColumnName);
	   				col_Num=columns.get(ColumnName);
	   				System.out.print("col_Num"+col_Num);
	   			}
            System.out.print("Step10");
           // sheet.autoSizeColumn(col_Num);
            System.out.print("Step11");
	   			if(!(columns.containsKey(ColumnName))){
	   				System.out.print("Step12");
	   				cellC=rowC.createCell(col_Num);	
	   			}
	   			else {
	   				System.out.print("Step13");
	   				cellC=rowC.getCell(col_Num);
	   			}
		   	    cellC.setCellValue(text);
		   	 System.out.print("Step14");
	    		fos = new FileOutputStream(ConfigReader.writeexcel());
	    		System.out.print("Step15");
	    		workbook.write(fos);
	    		System.out.print("Step16");
	    		fos.flush();
	    		System.out.print("Step17");
	    		fos.close();
	    		System.out.print("Step18");
	    	}
	    	catch (Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	    	finally {
	    	try {
				if(workbook!= null) {
				workbook.close(); }
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	}
	    } 
	    */
	    
	/*    public  void SetColumnname(String sheetname, String ColumnName,int rownum) throws Exception {
	   	try {
	   		fis = new FileInputStream(new File(ConfigReader.writeexcel()));
	   	    workbookC = WorkbookFactory.create(fis);
	   		for (int i=0; i<workbook.getNumberOfSheets(); i++) {
	   		   bool=workbook.getSheetName(i).toString().equalsIgnoreCase(sheetname);
	   		   if(bool==true) {
	   				 break;
	   			 }
	   		}
	   		if(bool==false) {
	   			   newSheet = workbook.createSheet(sheetname);
	   		 }
	   		  else {
	   			   newSheet =workbook.getSheet(sheetname);
	   		  }
	   		
	   		 int rown= newSheet.getLastRowNum();
	   		 
   			 if(rown>=rownum) {
   				rowC= newSheet.getRow(rownum);
   			 }
   			 else {
   				rowC= newSheet.createRow(rownum);
   			 }
   		  
	   		 //adding all the column header names to the map 'columns'
			 sheet.getRow(0).forEach(cell0 ->{
	                columns.put(cell0.getStringCellValue(), cell0.getColumnIndex());   });
			 int lastcellNum=rowC.getLastCellNum();
			if( !(columns.containsKey(ColumnName))){
				System.out.print("Excel Check");
				System.out.println("rowC.getLastCellNum() "+lastcellNum);
				if(lastcellNum<0) {
					lastcellNum=1;
				}
				cellC = rowC.createCell(lastcellNum);
			}
				cell.setCellValue(ColumnName);
				fos  = new FileOutputStream(ConfigReader.writeexcel());
	             workbook.write(fos);
	            	
	   	}
	             catch (Exception e) {
	                 e.printStackTrace();
	             }
	       
	   	  finally {
	   		workbook.close();
	   		  if (fos != null) {
	   			fos.close();
            }
	   		  
	   	}
	   }*/

	/*    public  void setCellData(String sheetname, String ColumnName,int rownum,String value) throws Exception {
	   	  Boolean bool = null;

	   	try {
	   		fis = new FileInputStream(new File(ConfigReader.writeexcel()));
	   		   workbookC = WorkbookFactory.create(fis);
	   		  for (int i=0; i<workbook.getNumberOfSheets(); i++) {
	   			   bool=workbook.getSheetName(i).toString().equalsIgnoreCase(sheetname);
	   			 if(bool==true) {
	   				 break;
	   			 }
	   			}
	   		  if(bool==false) {
	   			   newSheet = workbook.createSheet(sheetname);
	   		  }
	   		  else {
	   			   newSheet =workbook.getSheet(sheetname);
	   		  }
	   		
	   		 int rown= newSheet.getLastRowNum();
	   		 
	   			 if(rown>=rownum) {
	   				rowC= newSheet.getRow(rownum);
	   			 }
	   			 else {
	   				rowC= newSheet.createRow(rownum);
	   			 }
	   		  
	   		 //adding all the column header names to the map 'columns'
				 sheet.getRow(0).forEach(cell0 ->{
		                columns.put(cell0.getStringCellValue(), cell0.getColumnIndex());
		            });
					cellC = rowC.createCell(columns.get(ColumnName));
	   	       cellC.setCellValue(value);
	   	    out  = new FileOutputStream(new File(ConfigReader.writeexcel()));
            workbook.write(out);
     
	             }
	             catch (Exception e) {
	                 e.printStackTrace();
	             }
	       
	    finally {
	   		workbook.close();
	   		  if (fos != null) {
	   			fos.close();
            }
	   	
	   	}
	   }*/

}
