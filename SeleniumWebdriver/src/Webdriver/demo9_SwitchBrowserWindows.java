package Webdriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo9_SwitchBrowserWindows {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 

		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");

		String parentWin=driver.getWindowHandle();
		System.out.println("parent window handle= "+parentWin);
		WebElement button=driver.findElement(By.id("button1"));

		//to click on a button 3 times to open 3 windows
		for(int i=0;i<3;i++)
		{
			button.click();
			Thread.sleep(500);
		}

		List<String> allWin=new ArrayList<String>(driver.getWindowHandles());
		System.out.println("The parent and child windows handles are= "+allWin);

		String LastWindow="";
		for(int i=0; i<allWin.size();i++)
		{
			driver.switchTo().window(allWin.get(i));
			driver.get("http://www.google.com");
			String title=driver.getTitle();
			System.out.println("The title of window no "+i+" is= "+title);
			LastWindow=allWin.get(i).toString();
		}
		driver.switchTo().window(parentWin);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		System.out.println("Title of parent window= "+driver.getTitle());
		driver.close();
		driver.switchTo().window(LastWindow);
		driver.navigate().to("http://newtours.demoaut.com/");    //this is faster
		//driver.get("http://newtours.demoaut.com/");              //this is slower as it waits for full page load.
		System.out.println("Title of last child window= "+driver.getTitle());




	}

}
