package TestNGModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(Library.TestNGListener.clss)
public class MyListenerTest {
	static WebDriver driver;
	
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
		//driver.close();
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
