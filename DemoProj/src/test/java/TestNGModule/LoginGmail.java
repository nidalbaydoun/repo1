package TestNGModule;

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

public class LoginGmail {
	static WebDriver driver;

	
	
		
	

	
	// TC2 verify login
	@Test
	public static void VerifyTest()
	{
	// By
			By user = By.name("Email");
			By next = By.name("signIn");
			By pass = By.name("Passwd");
			
			// Write to the fields
			WebElement we=driver.findElement(user);
			we.sendKeys("nidal.baydoun@gmail.com");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);	
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement we2 = wait.until(ExpectedConditions.elementToBeClickable(next));
			we2.click();	
			
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