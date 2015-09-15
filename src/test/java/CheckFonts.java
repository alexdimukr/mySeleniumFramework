package test.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import main.java.application.common.pages.MainMenu;
import main.java.application.pages.AboutPage;
import main.java.application.pages.CommunityPage;
import main.java.application.pages.DeveloperPage;
import main.java.application.pages.MainPage;
import main.java.application.pages.PartnerPage;
import main.java.application.pages.SupportPage;
import main.java.application.pages.TrainingPage;
import net.sourceforge.htmlunit.corejs.javascript.tools.shell.QuitAction;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckFonts {
	
	private WebDriver driver;
	
	String font_family = "";
	int TestedElements = 0;
	
	//@BeforeMethod
	public void setUp() {
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	//@Test
	public void testCheckFonts() {
		driver.get("http://go.sap.com");
		MainPage mainPage = new MainPage(driver);
		

		
//		List<WebElement> inputs = driver.findElementsBy(By.tagName("input"));
//		List<WebElement> links = driver.findElementsBy(By.tagName("a"));
		
//		for (WebElement el : links) {
//			  String text = el.getText();
//			  String href = el.getAttribute("href");
		
		
		List<WebElement> all = driver.findElements(By.cssSelector("*"));
		System.out.println("amount of elements = " + all.size());


		
//		
//		List<WebElement> textOnly = new ArrayList<>();
//		// get amount of elements that contains text
//		
//			for ( WebElement e : all ) {
//				try {
//					if (e.getText().length()>1) {
//						textOnly.add(e);
//					}
//				}
//				catch (StaleElementReferenceException exception) {
//					//System.out.println("StaleElementReferenceException = " + exception.getMessage());
//				}
//			}
//			System.out.println("Amount of text elements = " + textOnly.size());	
//			
//		
//		// all - all elements
//		// textOnly - text only elements
//		for ( WebElement e : textOnly ) {
//			
//			if ((e.getCssValue("font-family").contains("BentonSansMedium")) || (e.getCssValue("font").contains("BentonSansMedium")))
//			{
//				System.out.println("PASSED - Tested element "
//						+ "  Text in the element is=" + e.getText()
//						+ "  TagName=" + e.getTagName()
//						+ "  Class=" + e.getClass()
//						+ "  Type=" + e.getAttribute("type"));
//			}
//			else 
//			{
//				System.out.println("FAILED - The following element does not contain expected font. "
//						+ "Text in the element is=" + e.getText()
//						+ "  TagName=" + e.getTagName()
//						+ "  Class=" + e.getClass()
//						+ "  Type=" + e.getAttribute("type"));
//			}
//				
//			System.out.println(TestedElements++);
//		}
//		
//		System.out.println("Total amount of tested elements is: " + TestedElements);
			  
	}
	
	
}
