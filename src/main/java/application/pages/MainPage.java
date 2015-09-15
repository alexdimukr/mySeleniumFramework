package main.java.application.pages;

import main.java.application.common.pages.Footer;
import main.java.application.common.pages.MainMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MainPage {
	
	private WebDriver driver;
	private MainMenu mainMenu;
	private Footer footer;
	
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		this.mainMenu = new MainMenu(driver);
		this.footer = new Footer(driver);
		
		if (!"SAP Software & Solutions | Technology & Business Applications".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the main page");
		}
	}
	
//		By searchFieldLocator = By.id("test");
//		By LogOnLocator = By.id("test");
//		
//		By searchSubmitButtonLocator = By.xpath("//tr[@class='search__row']/*/button");
		
	
}
