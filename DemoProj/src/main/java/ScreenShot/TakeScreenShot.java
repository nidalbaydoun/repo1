package ScreenShot;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TakeScreenShot {
	
	public static void tScreenShot (String outputPath, WebDriver driver) throws IOException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File(outputPath));
	}
    
	public static void main( String[] args ) throws Exception
    {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nidal\\Desktop\\skiva\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://www.google.com/");
		TakeScreenShot.tScreenShot("c:\\temp\\screenshot.png", driver);
    	System.out.println("Take screen shot");
    }
}
