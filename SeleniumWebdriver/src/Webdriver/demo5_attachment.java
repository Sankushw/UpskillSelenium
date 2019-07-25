package Webdriver;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo5_attachment {


		public static void main(String[] args)
		{
			System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();    //..... will open new instance of firefix  but only till certainn version

			driver.get("http://elearning.upskills.in/");
			driver.manage().window().maximize();
			String title= driver.getTitle();
			System.out.println("page title before login= "+title);
			
			driver.findElement(By.id("login")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("admin@123");
			driver.findElement(By.name("submitAuth")).click();
			
			driver.findElement(By.linkText("Import users list")).click();
			
			driver.findElement(By.name("import_file")).sendKeys("C:\\Users\\IBM_ADMIN\\Desktop\\Response attachment.txt");
			
			
			
			
			
			
	}
		
}
