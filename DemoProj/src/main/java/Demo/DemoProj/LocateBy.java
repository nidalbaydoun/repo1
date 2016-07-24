package Demo.DemoProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateBy {
	public static void main (String[] args)
	{
		// Define the driver interface
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nidal\\Desktop\\skiva\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Reach the website
		driver.get("https://www.amazon.com");
		
		// Locate by id
		By byid = By.id("nav-your-amazon");
		WebElement weid=driver.findElement(byid);
		
		// Click
		weid.click();
		
		// Go back
		driver.navigate().back();
		
		// Locate by linkText
		By bylink = By.linkText("Today's Deals");
		WebElement welink = driver.findElement(bylink);
		// Click
		welink.click();
		// Go back
		driver.navigate().back();
		
		// Locate by partialLinkText
		By bypartiallink = By.partialLinkText("Registry");
		WebElement wepartlink = driver.findElement(bypartiallink);
		// Click
		wepartlink.click();
		// Go back
		driver.navigate().back();
		driver.close();
	}
}
