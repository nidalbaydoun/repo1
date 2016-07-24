package TestNGModule;

import gmailpages.HomePage;
import gmailpages.LoginPage;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest_Refactor {
	static WebDriver driver;
	
	// TC2 verify login
	@Test
	public static void VerifyTest() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		//login.enterUserName("nidal.baydoun@gmail.com");
		//login.goNext();
		//login.enterPassword("TTTTTT");
		
		login.justLogin("nidal.baydoun@gmail.com", "Mariam1970-");
	}

	@Test
	public static void verifiyCompose() throws InterruptedException
	{
		HomePage home = new HomePage(driver);
		home.composeEmail("nidal.baydoun@gmail.com", "Test subject", "Content of my email", "");
	}
	
	@Test
	public static void verifiyReceive() throws InterruptedException
	{
		HomePage home = new HomePage(driver);
		if (home.receiveEmail("Test subject"))
		{
			System.out.println("Received");
		}
		else
		{
			System.out.println("Not Received");			
		}
		
		Thread.sleep(3000);
	}
	
	@Test
	public static void verifiyComposeWithAttachment() throws InterruptedException
	{
		HomePage home = new HomePage(driver);
		home.composeEmail("nidal.baydoun@gmail.com", "Test subject", "Content of my email", "");
	}
	
	@Test
	public static void verifiySignOut() throws InterruptedException
	{
		HomePage home = new HomePage(driver);
		//home.signOut();	
	}
	
	//Before class init driver
	@BeforeClass
	public static void MyBeforeClassTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nidal\\Desktop\\skiva\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
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
		//driver.manage().window().maximize();
	}
	// After method print TC exec
	@AfterMethod
	public static void MyAfterMethodTest()
	{
		//System.out.println("Test exec");
	}
}