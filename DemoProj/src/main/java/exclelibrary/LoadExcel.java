/*
 * Pb2: Use the data provider to print the content of the file using @AfetMethod
 * Pb3: Library with methods
 * 	getValue(sheet,row,cell) that returns cell value as string regardless of celltype
 * 	getTotalRows(sheet, headerRowCount) should returns total rows excluding the header rows
 * 	getLastRowIndex(sheet) should return the index of last row
 * Pb4:Library witn TakesScreenshot
 * */

package exclelibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoadExcel {
	
	public static Object getValue(String path, int isheet, int row, int ce) throws Exception
	{
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		File xlsxFile=new File(path); //calls the constructor
		// Create and input stream
		FileInputStream fis=new FileInputStream(xlsxFile);
		// Get workbook
		workbook = new XSSFWorkbook(fis);
		// Get sheet
		sheet =workbook.getSheetAt(isheet);
		
		switch (sheet.getRow(row).getCell(ce).getCellType())
		{
		case Cell.CELL_TYPE_STRING:
			String v =  sheet.getRow(row).getCell(ce).getStringCellValue();
			workbook.close();
			return v;
		case Cell.CELL_TYPE_NUMERIC: 
			double v2 = sheet.getRow(row).getCell(ce).getNumericCellValue();
			workbook.close();
			return v2;
		default:
			workbook.close();
			return "";
		}
	}
	
	
	public static int getTotalRows(String path, int isheet, boolean headerRowCount) throws IOException
	{
		int icount = 0;
		XSSFSheet sheet;
		File xlsxFile=new File(path); //calls the constructor
		// Create and input stream
		FileInputStream fis=new FileInputStream(xlsxFile);
		// Get workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Get sheet
		sheet = workbook.getSheetAt(isheet);
		
		icount = sheet.getLastRowNum();
		if(headerRowCount)
			return icount + 1;
		else
			return icount;
	}
	
	public static int getLastRowIndex(String path, int isheet) throws IOException
	{
		int icount = 0;
		XSSFSheet sheet;
		File xlsxFile=new File(path); //calls the constructor
		// Create and input stream
		FileInputStream fis=new FileInputStream(xlsxFile);
		// Get workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Get sheet
		sheet = workbook.getSheetAt(isheet);
		
		icount = sheet.getLastRowNum();

		return icount;
	}
    public static void main( String[] args ) throws Exception
    {
    	//System.out.println(LoadExcel.getValue("C:\\skiva\\data\\data1.xlsx", 0, 0, 0));
    	//System.out.println(LoadExcel.getValue("C:\\skiva\\data\\data1.xlsx", 0, 1, 1));
    	//System.out.println(LoadExcel.getTotalRows("C:\\skiva\\data\\data1.xlsx", 0, false));
    	//System.out.println(LoadExcel.getLastRowIndex("C:\\skiva\\data\\data1.xlsx", 0));
    }
}
