package TestNGModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POWSmokeTest {

static WebDriver driver;
	
	// TC1 Load facebook
	@Test
	public static void TC1Test()
	{
		System.out.println("TC1 Execution");
		driver.get("http://104.238.103.200:8080/POWNew/");
	}
	
	// TC2 Admin link
	@Test(dependsOnMethods ={"TC1Test"})
	public static void TC2VerifyLoginTest()
	{
		By classname = By.cssSelector("a[href^='/POWNew/startadmin.do']");
		WebElement we=driver.findElement(classname);
		we.click();	
		By idLocator = By.id("email");
		WebElement we2=driver.findElement(idLocator) ;
		we2.sendKeys("pow_a32@yahoo.com");
		By idLocator2 = By.id("password");
		WebElement we3=driver.findElement(idLocator2) ;
		we3.sendKeys("powadmin");
		By idLocator4 = By.id("loginbutton");
		WebElement we4=driver.findElement(idLocator4) ;
		we4.click();
		boolean loginstatus = false;
		if
		(
			driver.getPageSource().contains("No. of Vendors")&&
			driver.getPageSource().contains("No. of PO Requests")&&
			driver.getPageSource().contains("No Of Messages")&&
			driver.getPageSource().contains("Open POR")&&
			driver.getPageSource().contains("Delivered PO")&&
			driver.getPageSource().contains("Pending PO")&&
			driver.getPageSource().contains("Open Invoices")&&
			driver.getPageSource().contains("Paid Invoices")
		)
			loginstatus = true;
			Assert.assertTrue(loginstatus);			
	}
	
	@Test(dependsOnMethods ={"TC1Test"})
	public static void TC3VendorTest()
	{
		By hrefbegin = By.cssSelector("a[href^='/POWNew/admin/vendorlist.do']");
		WebElement we=driver.findElement(hrefbegin);
		we.click();
		boolean pagetitlecorrect =false;
		if (driver.getTitle() == "Vendor Management")
			pagetitlecorrect = true;
		boolean cintainsventdorlist =false;
		
		Assert.assertTrue(pagetitlecorrect && cintainsventdorlist);
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
