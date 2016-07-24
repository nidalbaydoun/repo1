package TestNGModule;
/*
 * Pb2: Use the data provider to print the content of the file using @AfetMethod
 * Pb3: Library with methods
 * 	getValue(sheet,row,cell) that returns cell value as string regardless of celltype
 * 	getTotalRows(sheet, headerRowCount) should returns total rows excluding the header rows
 * 	getLastRowIndex(sheet) should return the index of last row
 * Pb4:Library witn TakesScreenshot
 * */

import java.io.File;
import java.io.FileInputStream;

import junit.framework.Assert;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataGenerator {
	static WebDriver driver;
	int rows = 0;

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	@DataProvider(name="dparray")
	public Object[][] buildDataArr() throws Exception{
		Object [][] obj = null;
		int cols = 4;	
		
		// Load the data from excel
		// Locate the excel file
		File xlsxFile=new File("C:\\skiva\\data\\data1.xlsx"); //calls the constructor
		// Create and input stream
		FileInputStream fis=new FileInputStream(xlsxFile);
		// Get workbook
		workbook = new XSSFWorkbook(fis);
		// Get sheet
		sheet =workbook.getSheetAt(0);
		// Determine the rows
		rows = sheet.getLastRowNum();
		// Get cell
		obj = new Object [rows+1] [cols];
		
		for (int i=0; i<=rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);
			}
		}
		return obj;
	}
		
	@Test(dataProvider="dparray")
	public void verifyText2EqualsTest(String Text0, String Text1, String Text2, String Text3)
	{
		//Assert.assertEquals(Text2.equals("Facebook"), true);
	}
	
	//@Test(dataProvider="dparray")
	public void verifyText1BelongsTest(String Text0, String Text1, String Text2, String Text3)
	{
		//Assert.assertTrue(verifInput(Text1));
	}
	
	public boolean verifInput(String Text1)
	{
		if(Text1 == "Careers" || Text1 == "Mobile" || Text1 == "Developers" || Text1 == "Games")
			return true;
		else
			return false;
	}
		
	//Before class init driver
	@BeforeClass
	public static void MyBeforeClassTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nidal\\Desktop\\skiva\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	// After class close driver
	@AfterClass
	public static void MyAfterClassTest()
	{
		driver.close();
	}
	
	// Before method maximise the window
	@BeforeMethod
	public static void MyBeforeMethodTest()
	{
		//driver.manage().window().maximize();
	}
	// After method print TC exec
	@AfterMethod
	public static void MyAfterMethodTest()
	{
		//System.out.println("Test exec");
	}
}
