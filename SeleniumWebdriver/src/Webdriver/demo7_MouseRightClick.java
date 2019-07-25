
package Webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demo7_MouseRightClick {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 

		//driver.get("http://retail.upskills.in/admin/");
		driver.get("http://realestate.upskills.in/admin");
		driver.manage().window().maximize();

		driver.findElement(By.name("log")).sendKeys("Admin");
		driver.findElement(By.name("pwd")).sendKeys("adminuser@12345");
		driver.findElement(By.name("login")).click();

		WebElement userlink=driver.findElement(By.xpath("//*[contains(text(),'Howdy')]"));
		String title1=driver.getTitle();
		System.out.println("Tab 1 title= "+title1);

		Actions act=new Actions(driver);
		act.contextClick(userlink).build().perform();

		//to select 2nd option from right click
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);

		//to move the mouse to next tab and click
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		String title2=driver.getTitle();
		System.out.println("Tab 2 title= "+title2);


	}

}
