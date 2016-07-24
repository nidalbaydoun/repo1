package gmailpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	static WebDriver driver;
	
	public HomePage(WebDriver d)
	{
		driver = d;
	}
	
	public  void signOut() throws InterruptedException
	{
		By cssstringcontain = By.cssSelector("a[href*='SignOutOptions']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement westringcontain = driver.findElement(cssstringcontain);
		WebElement westringcontain = wait.until(ExpectedConditions.elementToBeClickable(cssstringcontain));
		westringcontain.click();	
		By cssso = By.cssSelector("a[href*='Logout']");
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		
		WebElement we = wait.until(ExpectedConditions.elementToBeClickable(cssso));
		we.click();	
	}
	
	public  void composeEmail(String addresses, String subject, String content, String attachment) throws InterruptedException
	{
		// Locate compose button
		By cssstringclassname = By.cssSelector("div[class*='T-I J-J5-Ji T-I-KE L3']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement we = wait.until(ExpectedConditions.elementToBeClickable(cssstringclassname));
		we.click();	
		
		// Insert email addresses
		By to = By.name("to");
		WebDriverWait wait2 = new WebDriverWait(driver, 10);	
		WebElement we2 = wait2.until(ExpectedConditions.elementToBeClickable(to));
		we2.sendKeys(addresses);
		
		// Insert address
		By sub = By.name("subjectbox");
		WebDriverWait wait3 = new WebDriverWait(driver, 10);	
		WebElement we3 = wait3.until(ExpectedConditions.elementToBeClickable(sub));
		we3.sendKeys(subject);
		
		// Insert content
		By css3 = By.cssSelector("div[aria-label*='Message Body']");
		WebDriverWait wait4 = new WebDriverWait(driver, 10);
		WebElement we4 = wait4.until(ExpectedConditions.elementToBeClickable(css3));
		we4.sendKeys(content);
	
		// Add attachment
		if (!attachment.equals(""))
		{
			// Locate the attachment button
			// Add the path to the input field
			// Press attach
			By css5 = By.cssSelector("div[id*=':pm']");
			WebDriverWait wait5 = new WebDriverWait(driver, 10);
			WebElement we5 = wait5.until(ExpectedConditions.elementToBeClickable(css5));
			we5.click();
		}
			
		// Send
		By css5 = By.cssSelector("div[data-tooltip^='Send']");
		WebDriverWait wait5 = new WebDriverWait(driver, 10);
		WebElement we5 = wait5.until(ExpectedConditions.elementToBeClickable(css5));
		we5.click();	
		
		
		// Send email
		// Locate fields and fill up
		// Locate and click the send button
		// 
	}
	
	public  boolean receiveEmail(String expectedSubject) throws InterruptedException
	{
		By css5 = By.cssSelector("a[title*='Inbox']");
		WebDriverWait wait5 = new WebDriverWait(driver, 10);
		WebElement we5 = wait5.until(ExpectedConditions.elementToBeClickable(css5));
		we5.click();		
		return driver.getPageSource().contains(expectedSubject);
	}
}
