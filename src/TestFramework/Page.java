package TestFramework;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Page {

	public static WebDriver driver = null;
	public static Properties CONFIG =null;
	
	
	public static boolean isLoggedIn=false;
	
	public static WebDriver InitBrowser(String browser,String Url)
	{
			System.out.println(browser);
			if(browser.equals("Mozilla"))
			    driver=new FirefoxDriver();
			else if(browser.equals("IE"))
			    driver=new InternetExplorerDriver();
			else if(browser.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
				
			    driver=new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(Url);
	return driver;
	}
	public static void CloseDriver()
	{
		driver.close();
	}
}
