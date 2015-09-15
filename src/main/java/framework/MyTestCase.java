package main.java.framework;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import main.java.framework.Browser;
import main.java.framework.GlobalConfiguration;


public class MyTestCase {
	protected WebDriver driver;
	public Browser browser;
	public GlobalConfiguration gc;
	
	
	@BeforeTest
	public void setUp() {

		String driverBrowser = System.getProperty("webdriver.browser");
		if (driverBrowser!=null)
		{
			switch (driverBrowser.toLowerCase())
			{
				case "firefox": this.driver = new FirefoxDriver();
				case "chrome":
					System.setProperty("webdriver.chrome.driver", "c:\\Users\\Oleksandr_Yaroslavtsev@epam.com\\workspace\\GoSap\\extra\\chromedriver.exe");
					this.driver = new ChromeDriver();
					Reporter.log("Chrome browser initialized", true);
			}
		}
		else
		{
			this.driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Browser=" + driverBrowser, true);
		
		this.browser = new Browser(driver);
		this.gc = new GlobalConfiguration();
		browser.resizeBrowser(gc.getbrowserDefaultWidth(), gc.getbrowserDefaultHeight());
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
 