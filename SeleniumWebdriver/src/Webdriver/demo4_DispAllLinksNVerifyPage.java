package Webdriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class demo4_DispAllLinksNVerifyPage {

	public static void main(String[] args) throws MalformedURLException, IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 

		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		System.out.println("page title before login= "+driver.getTitle());

		//finding all links in the page
		List<WebElement> links= driver.findElementsByTagName("a");
		System.out.println("The no of links on this page is= "+links.size());
		
		//storing all link labels in a array
		String[] linkarr= new String[links.size()];
		for(int i=0; i<links.size();i++)
		{

			linkarr[i]=links.get(i).getText();

		}

		//picking the links from array and clicking on that link
		for(int i=0; i<links.size();i++)
		{
			driver.findElementByLinkText(linkarr[i]).click();
			String Title=driver.getTitle();

			if(Title.equals("Under Construction: Mercury Tours"))
			{
				System.err.println(linkarr[i]+"---->This page is still under construction");   //to display output in red color..System.err.println
			}
			else if(!Title.equals("Under Construction: Mercury Tours"))
			{
				System.out.println(linkarr[i]+"---->This page is working");
				
			}
			
			else
			{
				System.out.println("This page navigates to error page");
			}
			driver.navigate().back();
		}
	}
}