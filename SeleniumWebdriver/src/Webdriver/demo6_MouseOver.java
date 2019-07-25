package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class demo6_MouseOver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		WebElement Login=driver.findElement(By.id("btnLogin"));

		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();   //using enter key directly on login button
		//act.moveToElement(Login).click();           //using click() method on login button
		Thread.sleep(2000);

		//act.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();
		WebElement PIM=driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b"));
		
		act.moveToElement(PIM).build().perform();
		WebElement empList=driver.findElement(By.id("menu_pim_viewEmployeeList"));
		empList.click();
		Thread.sleep(2000);
		
		//to scroll down
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
	
	}

}
