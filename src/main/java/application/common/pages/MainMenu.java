package main.java.application.common.pages;

import main.java.application.pages.AboutPage;
import main.java.application.pages.CommunityPage;
import main.java.application.pages.DeveloperPage;
import main.java.application.pages.MainPage;
import main.java.application.pages.PartnerPage;
import main.java.application.pages.SupportPage;
import main.java.application.pages.TrainingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainMenu {

	private WebDriver driver; 
	
	By supportPageLocator = By.xpath("//a[@class='mmLink']/span[text()='Support']");
	By trainingPageLocator = By.xpath("//a[@class='mmLink']/span[text()='Training']");
	By communityPageLocator = By.xpath("//a[@class='mmLink']/span[text()='Community']");
	By developerPageLocator = By.xpath("//a[@class='mmLink']/span[text()='Developer']");
	By partnerPageLocator = By.xpath("//a[@class='mmLink']/span[text()='Partner']");
	By aboutPageLocator = By.xpath("//a[@class='mmLink']/span[text()='About']");
	
	By searchFieldLocator = By.id("test");
	By LogOnLocator = By.id("test");
	
	By searchSubmitButtonLocator = By.xpath("//tr[@class='search__row']/*/button");
	
	
	public MainMenu(WebDriver driver){
		this.driver = driver;
	}
	
		public SupportPage openSupport() {
			driver.findElement(supportPageLocator).click();
			return new SupportPage(driver);
		}
		
		
		public TrainingPage openTraining() {
			driver.findElement(trainingPageLocator).click();
			return new TrainingPage(driver);
		}
		
		
		public CommunityPage openCommunity() {
			driver.findElement(communityPageLocator).click();
			return new CommunityPage(driver);
		}
		
		
		public DeveloperPage openDeveloper() {
			driver.findElement(developerPageLocator).click();
			return new DeveloperPage(driver);
		}
		
		
		public PartnerPage openPartner() {
			driver.findElement(partnerPageLocator).click();
			return new PartnerPage(driver);
		}
		
		
		public AboutPage openAbout() {
			driver.findElement(aboutPageLocator).click();
			return new AboutPage(driver);
		}
	
		
		// to be Done
		public MainMenu search(String searchString) {
			driver.findElement(searchFieldLocator).click();
			// add search functionality here
			return this;
		}
		
		
		// to be Done
		public MainMenu logon(String username, String password) {
			driver.findElement(LogOnLocator);
			
			// enter parameters here
			return this;
		}
		
	
}
