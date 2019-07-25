package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demo1_Basic {

	public static void main(String[] args){

		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Jar files for Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();       /...... /will open new instance of firefix 

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();    //..... will open new instance of firefix  but only till certainn version
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		String title= driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals("OrangeHRM"))
		{
			System.out.println("The title of page is= "+actualTitle);
			
		}
		
		driver.findElement(By.id("welcome")).click();
		
		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		 
		 //  WebDriverWait wait = new WebDriverWait(driver, 160);
		//	wait.until(ExpectedConditions.visibilityOf(Requesting_Company)); 
			
			
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("The test is complete ");
		driver.close();



	}
}
