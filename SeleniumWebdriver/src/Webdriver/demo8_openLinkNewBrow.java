package Webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo8_openLinkNewBrow {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 

		//driver.get("http://retail.upskills.in/admin/");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String title1=driver.getTitle();
		System.out.println("Tab 1 title= "+title1);
		driver.findElement(By.linkText("Gmail")).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));

		// trying with window handler
		ArrayList<String> tabs=new ArrayList(driver.getWindowHandles());
		int size= tabs.size();
		System.out.println("no. of tabs= "+size);
		driver.switchTo().window(tabs.get(1));

		String title3=driver.getTitle();
		System.out.println("Tab 2 title= "+title3);

		if(title1.equals(title3))
		{
			System.out.println("same title");
		}
		else
		{
			System.out.println("Title are different");
		}


		
	}

}
