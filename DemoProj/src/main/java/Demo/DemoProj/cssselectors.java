package Demo.DemoProj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssselectors {

	public static void main (String[] args)
	{
		// Define the driver interface
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nidal\\Desktop\\skiva\\chromedriver.exe");
		driver = new ChromeDriver();
		// Reach the website
		driver.get("https:/amazon.com");
		// Locate Gift cards - 3 techniques
		// By string beginning
		//By cssstringbeginning = By.cssSelector("a[href^='/b/ref=nav_cs']");
		//WebElement westringbegin = driver.findElement(cssstringbeginning);
		//westringbegin.click();
		//driver.navigate().back();
	
		// By string end
		//By cssstringend = By.cssSelector("a[href$='14069511011']");
		//WebElement westringend = driver.findElement(cssstringend);
		//westringend.click();
		//driver.navigate().back();
		
		// By string contains
		//By cssstringcontain = By.cssSelector("a[href*='nav_cs_gc_registry']");
		//WebElement westringcontain = driver.findElement(cssstringcontain);
		//westringcontain.click();
		//driver.navigate().back();
	    
		// By class name
		//By cssstringclassname = By.cssSelector("span.nav-line-2");
		//WebElement weclassname = driver.findElement(cssstringclassname);
		//weclassname.click();
		//driver.navigate().back();
		
		// By tag id
		By csstagid = By.cssSelector("a#nav-your-amazon");
		WebElement wetagid = driver.findElement(csstagid);
		wetagid.click();
		
		// By several attributes
		By cssseveralattributes1 = By.cssSelector("input#ap_email[type='email']");
		WebElement weseveralattributes1 = driver.findElement(cssseveralattributes1);
		weseveralattributes1.sendKeys("120@yahoo.com");
		
		// By several attributes
		By cssseveralattributes2 = By.cssSelector("input#ap_password[type='password']");
		WebElement weseveralattributes2 = driver.findElement(cssseveralattributes2);
		weseveralattributes2.sendKeys("120@yahoo.com");
				
		// By several attributes
		By cssseveralattributes3 = By.cssSelector("input.a-button-input[aria-labelledby^='a-autoid']");
		WebElement weseveralattributes3 = driver.findElement(cssseveralattributes3);
		weseveralattributes3.click();
		
		// Check 
		if (driver.getPageSource().contains("Please try agian later")||
				driver.getPageSource().contains("better protect your account")
				)
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		//driver.navigate().back();
		
		// click
		// Navigate back
		
		//driver.close();
	}
}

	