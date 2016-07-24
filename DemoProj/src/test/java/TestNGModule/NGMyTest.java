package TestNGModule;

import junit.framework.Assert;

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

public class NGMyTest {
	static WebDriver driver;
	int rows = 0;
	
	@DataProvider(name="dparray")
	public Object[][] buildDataArr(){
		Object [][] obj = null;
		rows = 3;
		int cols = 2;	
		obj = new Object [rows] [cols];
		
		String[][] str={
				{"Messenger", "Facebook"},
				{"Mobile", "Facebook"},
				{"Developers", "Facebook"}
		};
		
		for (int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				obj[i][j] = str[i][j];
			}
		}
		return str;
	}
		
	@Test(dataProvider="dparray")
	public void verifyText2EqualsTest(String Text1, String Text2)
	{
		Assert.assertEquals(Text2.equals("Facebook"), true);
	}
	
	@Test(dataProvider="dparray")
	public void verifyText1BelongsTest(String Text1, String Text2)
	{
		Assert.assertTrue(verifInput(Text1));
	}
	
	public boolean verifInput(String Text1)
	{
		if(Text1 == "Messenger" || Text1 == "Mobile" || Text1 == "Developers")
			return true;
		else
			return false;
	}
	// TC1 Load facebook
	@Test
	public static void TC1Test()
	{
		System.out.println("TC1 Execution");
		driver.get("https://facebook.com");
	}
	
	// TC2 verify login
	@Test
	public static void VerifyTest()
	{
	// By
			By user = By.name("email");
			By pass = By.name("pass");
			
			By ip[] = {user, pass};
			
			// Write to the fields
			WebElement we=null;
			for(int i=0; i<2; i++)
			{
				we = driver.findElement(ip[i]);
				we.sendKeys("abcd1234");
			}
			
			// Find and click the login button
			driver.findElement(By.id("loginbutton")).click();
			
			// Check 
			if (driver.getPageSource().contains("The password that you've entered is incorrect"))
				System.out.println("TC1: Test case pass");
			else
				System.out.println("TC1: Test case fail");
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
		driver.manage().window().maximize();
	}
	// After method print TC exec
	@AfterMethod
	public static void MyAfterMethodTest()
	{
		System.out.println("Test exec");
	}
}