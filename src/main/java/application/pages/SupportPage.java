package main.java.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupportPage {
	
	private WebDriver driver;
	
	
	public SupportPage(WebDriver driver) {
		this.driver = driver;
		
		if (!"SAP Support & Maintenance | SAP".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the support page");
		}
	}
	
	By supportPageLocator = By.xpath("//a[@class='mmLink']/span[text()='Support']");
	By trainingPageLocator = By.id("//a[@class='mmLink']/span[text()='Training']");
	By communityPageLocator = By.id("//a[@class='mmLink']/span[text()='Community']");
	By developerPageLocator = By.id("//a[@class='mmLink']/span[text()='Developer']");
	By partnerPageLocator = By.id("//a[@class='mmLink']/span[text()='Partner']");
	By aboutPageLocator = By.id("//a[@class='mmLink']/span[text()='About']");
	
	By searchFieldLocator = By.id("test");
	By LogOnLocator = By.id("test");
	
	By searchSubmitButtonLocator = By.xpath("//tr[@class='search__row']/*/button");
	
	
		
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
	
	
}
