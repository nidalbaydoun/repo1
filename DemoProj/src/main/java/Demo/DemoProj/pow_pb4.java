package Demo.DemoProj;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pow_pb4 {
	public static void main (String[] args)
	{
		// Define the driver interface
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nidal\\Desktop\\skiva\\chromedriver.exe");
		driver = new ChromeDriver();
		// Reach the website
		driver.get("http://104.238.103.200:8080/POWNew/startaccount.do");
		
		// Locate by partialLinkText
		
		By cssstringclassname = By.cssSelector(".form-control.form-control-solid.placeholder-no-fix");
		List<WebElement> lis=driver.findElements(cssstringclassname);
		// Loop with size
		System.out.println(lis.size());
		for (int i=0; i<lis.size();i++)
		{
			System.out.println(i);
		}
		
		//  Loop with the iterator
		Iterator <WebElement> we=lis.iterator();
		WebElement test;
		String [] credentials = {"abc", "123"};
		int i = 0;
		while(we.hasNext())
		{
			test= we.next();
			test.sendKeys(credentials[i]);
			i++;
		}
			
		// Click
		//wepartlink.click();
				
		// By
		// user = By.name("email");
		//By pass = By.name("password");
		
		//By ip[] = {user, pass};
		
		// Write to the fields
		//WebElement weemail=driver.findElement(user);
		//weemail.sendKeys ("abccdabcd");//("pow_a32@yahoo.com");
		
		//WebElement wepass=driver.findElement(pass);
		//wepass.sendKeys("powadmin");
		
		//driver.navigate().back();
		
		//driver.close();
	}
		
		
}
