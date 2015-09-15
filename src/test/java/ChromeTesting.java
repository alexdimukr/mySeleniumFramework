package test.java;


import main.java.application.pages.*;
import main.java.application.common.pages.*;
import main.java.framework.MyTestCase;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeTesting extends MyTestCase {
	
	@Test
	public void chromeTest() throws Exception {
		
		Reporter.log("Driver that is used is: " + driver, true);
		
		driver.get("http://go.sap.com");
		
		//browser.log(String.valueOf(browser.isTextOnPagePresent("Rewards")));
		
		//browser.resizeBrowser(gc.getbrowserDefaultWidth(), gc.getbrowserDefaultHeight());
		
		MainMenu mainMenu = new MainMenu(driver);
		MainPage mainPage = new MainPage(driver);
		
		
		//browser.highlight(browser.findAllLinks(driver));
		browser.verifyPageLinks();
		
		
		SupportPage supportPage = mainMenu.openSupport();
		TrainingPage trainingPage = mainMenu.openTraining();
		CommunityPage communityPage = mainMenu.openCommunity();
		DeveloperPage developerPage = mainMenu.openDeveloper();
		PartnerPage partnerPage = mainMenu.openPartner();
		AboutPage aboutPage = mainMenu.openAbout();
	}
}
