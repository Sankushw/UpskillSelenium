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

public class demo2_dropdown {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Jar files for Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();       /...... /will open new instance of firefix 

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();    //..... will open new instance of firefix  but only till certainn version

		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		String title= driver.getTitle();
		System.out.println("page title before login= "+title);

		WebElement user=driver.findElement(By.name("userName"));
		user.sendKeys("sunil");

		if (user.isDisplayed())
		{
			String val= user.getAttribute("value");
			System.out.println("value in Username text box field= "+val);
			String val1=val.substring(0, 2);
			System.out.println("new value in username field= "+val1);

			String nam=user.getAttribute("name");
			System.out.println("The name attribute of username field is= "+nam);
			String substringedname =nam.substring(0, 3);
			System.out.println("substringed name= "+substringedname);
			String txt=user.getAttribute("type");
			System.out.println("The type attribute of username field is= "+txt);

			String x =driver.findElement(By.xpath("//*[contains(text(), 'User')]")).getText();
			System.out.println("Label of  username field= "+x);		}

		driver.findElement(By.name("password")).sendKeys("sunil");
		driver.findElement(By.name("login")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		//click on one way trip radio button
		WebElement radioround= driver.findElement(By.xpath("//*[@name='tripType' and @value='roundtrip']"));
		WebElement radioone= driver.findElement(By.xpath("//*[@name='tripType' and @value='oneway']"));

		if (radioround.isSelected())
		{
			radioone.click();
			System.out.println("Round way trip was selected by default and it is now changed to one way");
		}

		//to display all hyperlinks present in the page with anchor tag
		List<WebElement> links= driver.findElementsByTagName("a");
		for(int i=0; i<links.size();i++)
		{
			System.out.println(links.get(i).getText()+"---->"+ links.get(i).getAttribute("href"));
		}

		//Selecting the dropdown by visible text
		WebElement pc=driver.findElement(By.name("passCount"));
		Select sel=new Select(pc);
		sel.selectByVisibleText("2");

		//Selecting the dropdown by index
		WebElement port=driver.findElement(By.name("fromPort"));
		Select sel1=new Select(port);
		sel1.selectByIndex(7);

		//Selecting the dropdown by value
		WebElement frmon=driver.findElement(By.name("fromMonth"));
		Select sel2=new Select(frmon);
		sel2.selectByValue("4");

		//Display count and all the values of  dropdown
		WebElement frport=driver.findElement(By.name("fromPort"));
		Select selfport=new Select(frport);
		List <WebElement> li=selfport.getOptions();
		System.out.println("The no. of option present in the drop down are= "+li.size());
		
		for(int i=0;i<li.size();i++)
		{
			System.out.println("option " +(i+1)+ " = "+li.get(i).getText());
		}
		

		//driver.findElement(By.linkText("SIGN-OFF")).click();
		System.out.println("The test is complete ");

		driver.findElement(By.name("servClass")).click();
		
		driver.findElement(By.name("findFlights")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("reserveFlights")).click();
		
		
		driver.findElement(By.name("passFirst0")).sendKeys("Sanjay");
		driver.findElement(By.name("passLast0")).sendKeys("Kushwaha");
		driver.findElement(By.name("creditnumber")).sendKeys("454376549876");
		
		Thread.sleep(1000);
		List<WebElement> check=driver.findElements(By.name("ticketLess"));
		check.size();
		for(int i=0; (i<check.size()-1); i++)
		{
			check.get(i).click();
					}
		
		
		
		
		
		
		
		
		
		
	}
	
	


}

