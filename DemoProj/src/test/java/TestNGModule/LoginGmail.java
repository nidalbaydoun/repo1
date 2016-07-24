package TestNGModule;
// 24-7-2016 ... Adding logging component

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports; 
import com.relevantcodes.extentreports.ExtentTest; 
import com.relevantcodes.extentreports.LogStatus; 

public class LoginGmail {
	static WebDriver driver;
	// 1 - Logging of info - Global report and logger
	static ExtentReports report; 
	static ExtentTest logger; 
	
	// TC2 verify login
	@Test
	public static void VerifyTest()
	{

		// 3 - Logging - Within test logging
		logger=report.startTest("VerifyTest"); 
		logger.log(LogStatus.INFO, "Test Case Started"); 
		logger.log(LogStatus.INFO, "Input Condition: Message 1"); 
		logger.log(LogStatus.INFO, "Expected output: Message 2"); 
		
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

	// TC2 verify login
		@Test
		public static void VerifyTest2()
		{

			// 3 - Logging - Within test logging
			logger=report.startTest("VerifyTest2"); 
			logger.log(LogStatus.INFO, "Test Case Started"); 
			logger.log(LogStatus.INFO, "Input Condition: Message 1"); 
			logger.log(LogStatus.INFO, "Expected output: Message 2"); 
			
			// By
			By user = By.name("Email");
			By next = By.name("signIn");
			By pass = By.name("Passwd");
			
			// Write to the fields
			WebElement we=driver.findElement(user);
			we.sendKeys("nidal.Fail@gmail.com");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);	
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement we2 = wait.until(ExpectedConditions.elementToBeClickable(next));
			we2.click();	
		}
	
	//Before class init driver
	@BeforeClass
	public static void MyBeforeClassTest()
	{
		// 2 - Logging - Locate the log file
		String reportFile="./Reports/Current/results.html"; 
		report = new ExtentReports(reportFile); 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nidal\\Desktop\\skiva\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
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
	public void afterEachTest(ITestResult result)  
	{ 
		String tName=result.getName(); 
		//String tCaseId=result.toString(); 
		if(result.getStatus() == ITestResult.FAILURE) { 
			String thwomsg=result.getThrowable().getMessage(); 
		//	System.out.println("Test Case "+tName+" Failed !!"); 
			logger.log(LogStatus.FAIL, tName+" Failed"); 
			logger.log(LogStatus.FAIL, thwomsg); 
		 
		} else { 
			//System.out.println("Test Case "+tName+" Passed !!"); 
			logger.log(LogStatus.PASS,tName+" Passed"); 
			 
		} 
		 
	report.endTest(logger); 
	report.flush(); 
	} 
}