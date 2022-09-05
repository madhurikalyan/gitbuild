package Parallel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
// Main class


public class GFG {
	static String excelFilePath = "D:\\WorkingDirectory\\MODOT\\src\\test\\resources\\DataProvider\\gfgcontribute.xlsx";
  
	
	public static void writemydata(String sheetname, int rownum, int cellnum,String value) {
	  try {
		  FileInputStream inputStream;
		  Workbook workbook;
		  Boolean bool = null;
		  Sheet newSheet;
		  Row row ;
		  Cell cell;
		   inputStream = new FileInputStream(new File(excelFilePath));

		   workbook = WorkbookFactory.create(inputStream);
		  for (int i=0; i<workbook.getNumberOfSheets(); i++) {
			   bool=workbook.getSheetName(i).equalsIgnoreCase(sheetname);
			}
		  if(bool==false) {
			   newSheet = workbook.createSheet(sheetname);
		  }
		  else {
			   newSheet =workbook.getSheet(sheetname);
		  }
		 int rown= newSheet.getLastRowNum();
		
			 if(rown>=rownum) {
				 row= newSheet.getRow(rownum);
			 }
			 else {
				 row= newSheet.createRow(rownum);
			 }
	
		  // row = newSheet.createRow(rownum);
		   cell = row.createCell(cellnum);  
	       cell.setCellValue(value);
               // Writing the workbook
               FileOutputStream out = new FileOutputStream(
                   new File(excelFilePath));
               workbook.write(out);
               workbook.close();
               // Closing file output connections
               out.close();
               // Console message for successful execution of
               // program
               System.out.println(
                   "gfgcontribute.xlsx written successfully on disk.");
           }
           // Catch block to handle exceptions
           catch (Exception e) {
     
               // Display exceptions along with line number
               // using printStackTrace() method
               e.printStackTrace();
           }
     

  }
    // Main driver method
    public static void main(String[] args)
    {
    	writemydata("Account",0,0,"MCE Customer ID");
    	writemydata("Account",0,1,"Registrant Type");
    	writemydata("Account",0,2,"Carrier Type");
    	writemydata("Account",0,3,"IFTA Account No.");
    	writemydata("Account",0,4,"Customer Status");
    	writemydata("Account",1,0,"987897465");
    	writemydata("Account",1,1,"S - Limited Partnership");
    	writemydata("Account",1,2,"C - CARRIER");
    	writemydata("Account",1,3,"");
    	writemydata("Account",1,4,"A - ACTIVE");
       
    	
    	
    	writemydata("PreSetup",0,0,"Account#");
    	writemydata("PreSetup",0,1,"MCE #");
    	writemydata("PreSetup",0,2,"Fleet#");
    	writemydata("PreSetup",0,3,"Fleet Expiration Year");
    	writemydata("PreSetup",0,4,"Title");
    	writemydata("PreSetup",1,0,"17313");
    	writemydata("PreSetup",1,1,"");
    	writemydata("PreSetup",1,2,"1");
    	writemydata("PreSetup",1,3,"2022");
    	writemydata("PreSetup",1,4,"IRP");
    	
    	
    	
    	writemydata("FleetTab",0,0,"Email iD");
    	writemydata("FleetTab",0,1,"IRP Requirements Form");
    	writemydata("FleetTab",0,2,"Statement of Understanding");
    	writemydata("FleetTab",0,3,"Installment Agreement");
    	writemydata("FleetTab",0,4,"Power of Attorney");
    	writemydata("FleetTab",1,0,"test@celtic.bz");
    	writemydata("FleetTab",1,1,"C - COLLECTED");
    	writemydata("FleetTab",1,2,"C - COLLECTED");
    	writemydata("FleetTab",1,3,"C - COLLECTED");
    	writemydata("FleetTab",1,4,"C - COLLECTED");
    	
    	
    	
    	writemydata("DistanceTab",0,0,"Juri");
    	writemydata("DistanceTab",0,1,"Distance");
    	writemydata("DistanceTab",0,2,"Comments");
    	writemydata("DistanceTab",0,3,"Estimated Distance");
    	writemydata("DistanceTab",0,4,"Actual Distance Reporting Period");
    	writemydata("DistanceTab",1,0,"MO - MISSOURI");
    	writemydata("DistanceTab",1,1,"80000");
    	writemydata("DistanceTab",1,2,"Distance tab Comments");
    	writemydata("DistanceTab",1,3,"");
    	writemydata("DistanceTab",1,4,"");
    	
       /* // Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
  
        // Creating a blank Excel sheet
        XSSFSheet sheet
            = workbook.createSheet("Account");
 
        // Creating an empty TreeMap of string and Object][]
        // type
        Map<String, Object[]> data
            = new TreeMap<String, Object[]>();
  
        // Writing data to Object[]
        // using put() method
        data.put("1",
                 new Object[] { "MCE Customer ID", "Registrant Type", "Carrier Type","IFTA Account No.","Customer Status" });
        data.put("2",
                 new Object[] {987897465, "S - Limited Partnership", "C - CARRIER","","A - ACTIVE" });

        // Iterating over data and writing it to sheet
        Set<String> keyset = data.keySet();
  
        int rownum = 0;
  
     //   for (String key : keyset) {
  
            // Creating a new row in the sheet
            Row row = sheet.createRow(rownum++);
  
     //       Object[] objArr = data.get(key);
  
            int cellnum = 0;
  
         //   for (Object obj : objArr) {
  
                // This line creates a cell in the next
                //  column of that row
                Cell cell = row.createCell(cellnum++);
  
               // if (obj instanceof String)
                    cell.setCellValue(String.valueOf(obj));
  
                //else if (obj instanceof Integer)
                  //  cell.setCellValue((Integer)obj);
            }
        }
  
        // Try block to check for exceptions
        try {
  
            // Writing the workbook
            FileOutputStream out = new FileOutputStream(
                new File("D:\\WorkingDirectory\\MODOT\\src\\test\\resources\\DataProvider\\gfgcontribute.xlsx"));
            workbook.write(out);
  
            // Closing file output connections
            out.close();
  
            // Console message for successful execution of
            // program
            System.out.println(
                "gfgcontribute.xlsx written successfully on disk.");
        }
  
        // Catch block to handle exceptions
        catch (Exception e) {
  
            // Display exceptions along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }*/

}

}