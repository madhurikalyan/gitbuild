package com.celtic.automation.cmcs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelUtil {

	  XSSFWorkbook workbook = null;  
	
	 public ReadExcelUtil(String xlFilePath)
	    {
		   FileInputStream fis = null;
		 
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
	    	XSSFSheet sheet = null;
	    	
	    	XSSFCell cell = null;
	    	Map<String, Integer> columns = new HashMap<>();
	    	String cellvalue=null;
	    	 
	    	try {
			 sheet = workbook.getSheet(SheetName);
			 //adding all the column header names to the map 'columns'
			 sheet.getRow(0).forEach(cellA ->{
	                columns.put(cellA.getStringCellValue(), cellA.getColumnIndex());
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

	    
}
