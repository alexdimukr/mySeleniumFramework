package test.java;

import java.util.concurrent.TimeUnit;

import main.java.application.common.pages.MainMenu;
import main.java.application.pages.AboutPage;
import main.java.application.pages.CommunityPage;
import main.java.application.pages.DeveloperPage;
import main.java.application.pages.MainPage;
import main.java.application.pages.PartnerPage;
import main.java.application.pages.SupportPage;
import main.java.application.pages.TrainingPage;
import main.java.framework.Browser;

import org.testng.Reporter;
import org.testng.ReporterConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestTopNavigation {
	private WebDriver driver;
	
	//@BeforeMethod
	public void setUp() {
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("checking this", true);
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	//@Test
	public void testTopNavigation() {
		//Browser browser = new Browser(driver);
		//browser.log("opening a browser");
		Reporter.log("asdasdasdasd", true);
		
		driver.get("http://go.sap.com");
		MainMenu mainMenu = new MainMenu(driver);
		MainPage mainPage = new MainPage(driver);
		SupportPage supportPage = mainMenu.openSupport();
		TrainingPage trainingPage = mainMenu.openTraining();
		CommunityPage communityPage = mainMenu.openCommunity();
		DeveloperPage developerPage = mainMenu.openDeveloper();
		PartnerPage partnerPage = mainMenu.openPartner();
		AboutPage aboutPage = mainMenu.openAbout();
		//MainPage mainPage = aboutPage.
	}
}
