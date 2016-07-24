package Demo.DemoProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
	public static void main (String[] args)
	{
		// Define the driver interface
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nidal\\Desktop\\skiva\\chromedriver.exe");
		driver = new ChromeDriver();
		// Reach the website
		driver.get("https://www.facebook.com");
		
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
		
		// Clear the elements
		for(int i=0; i<2; i++)
		{
			we = driver.findElement(ip[i]);
			we.clear();
			we.sendKeys(".");
		}
		
		driver.navigate().back();
		
		driver.close();
	}
		
		
}
