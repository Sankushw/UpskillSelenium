package Webdriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo3_IdentifyBrokenLinks {

	public static void main(String[] args) throws IOException{

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();    //..... will open new instance of firefix  but only till certainn version

		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		//to find all links present in the page with anchor tag and store in a list 
		List<WebElement> links= driver.findElementsByTagName("a");
		System.out.println("Totla no. of links present in this pahes is= "+links.size());

		for(int i=0; i<links.size();i++)
		{
			String url= links.get(i).getAttribute("href");
			//System.out.println(links.get(i).getText()+"---->"+ url);      //-----to display all links of page
			HttpURLConnection huc=(HttpURLConnection) new URL(url).openConnection();
			huc.setRequestMethod("HEAD");
			huc.connect();
			int respCode=huc.getResponseCode();
			if(respCode<=200)
			{
				System.out.println(links.get(i).getText()+"----->  "+url+"------>This link is working fine");
			}

			else if(respCode>200)
			{
				System.out.println(links.get(i).getText()+"----->"+url+"------>This link is broken");
			}
		}
	}
}