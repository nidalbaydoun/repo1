package gmailpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	static WebDriver driver;
	
	public LoginPage(WebDriver d)
	{
		driver = d;
	}
	
	public  void enterUserName(String name)
	{
		By user = By.name("Email");
		WebElement we=driver.findElement(user);
		we.sendKeys("nidal.baydoun@gmail.com");
	}
	
	public  void goNext(String str)
	{
		By next = By.id(str);

		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement we2 = wait.until(ExpectedConditions.elementToBeClickable(next));
		we2.click();
			
	}
	public  void enterPassword(String psassword)
	{
		By pwd = By.name("Passwd");

		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement we2 = wait.until(ExpectedConditions.elementToBeClickable(pwd));
		we2.sendKeys(psassword);
			
	}

	
	public  void justLogin(String username, String psassword)
	{
		enterUserName(username);
		goNext("next");
		enterPassword(psassword);
		goNext("signIn");
	}
	

	
}
