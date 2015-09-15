package main.java.framework;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	private WebDriver driver;
	private int defaultWaitTime = 20;
	
	
	public Browser(WebDriver driver){
		this.driver = driver;
	}
	
	
	public boolean isElementPresent(By by) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(by);
		driver.manage().timeouts().implicitlyWait(defaultWaitTime, TimeUnit.SECONDS);
		if (list.size() == 0) {
			return false;
		} else {
			return list.get(0).isDisplayed();
		}
//		try {
//			driver.findElement(by);
//			return true;
//		}
//		catch (NoSuchElementException e) {
//			return false;
//		}
	}
	
	
	public boolean isElementNotPresent(By by) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(by);
		driver.manage().timeouts().implicitlyWait(defaultWaitTime, TimeUnit.SECONDS);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
		
		
//		try {
//			driver.findElement(by);
//			return false;
//		}
//		catch (NoSuchElementException e) {
//			log ("Expected that element is not found");
//			return true;
//		}
	}
	
	
//	public void waitForElement() {
//		WebDriverWait waiter = new WebDriverWait(driver, defaultWaitTime, 1000);
//		waiter.until(new Predicate<WebDriver>() {
//			public boolean apply(WebDriver input) {
//				return isSomething(input);
//			}
//		});
//	}
	
	
	public void log (String message) {
		System.out.println(message);
	}
	
	
	public void resizeBrowser (int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}
	
	
	public String getProperties(By by, String param) {
		return driver.findElements(by).get(0).getAttribute(param);
	}
	
	
	public String getPageSource () {
		return driver.getPageSource();
	}
	
	
	public Point getElementLocation(By by) {
		return driver.findElements(by).get(0).getLocation();
	}
	
	
	public String getCSSProperty(By by, String param) {
		return driver.findElements(by).get(0).getCssValue(param);
	}
	
	
	public Dimension getSize (By by) {
		return driver.findElements(by).get(0).getSize();
	}
	
	


	
	// get all clickable items links <a> and <img href=> 
	// excluding missing href tags
	// excluding href='#'
	public List<WebElement> findAllLinks(WebDriver driver) {
		
		List<WebElement> elementList = driver.findElements(By.tagName("a"));
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		
		List<WebElement> finalList = new ArrayList<WebElement>();
		
		
		for (WebElement element : elementList) {
			if (element.getAttribute("href")!=null) { 
				if (!element.getAttribute("href").equals("#")) {
					// check if link is already in the list
					int i = 0;
					while (i < finalList.size()) {
						if ((element.getAttribute("href")).equals(finalList.get(i).getAttribute("href"))) {
							break;
						}
						i++;
					}
					if (i==finalList.size()) {
						finalList.add(element);
					}
				}
			}
		}
		
		for (WebElement element : imageList) {
			if (element.getAttribute("href")!=null) { 
				if (!element.getAttribute("href").equals("#")) {
					// check if link is already in the list
					int i = 0;
					while (i < finalList.size()) {
						if ((element.getAttribute("href")).equals(finalList.get(i).getAttribute("href"))) {
							break;
						}
						i++;
					}
					if (i==finalList.size()) {
						finalList.add(element);
					}
				}
			}
		}
		return finalList;
	}
	
	
	// Verification for broken link
	// Return Response Code
	// 200
	// 404
	// 403
	// etc
	public String isLinkBroken(URL url) throws Exception {
		int response = 0;
	
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();	
		try {
		    connection.connect();
		    response = connection.getResponseCode();
		    connection.disconnect();
		    return String.valueOf(response);
		}
		catch(Exception e) {
			return e.getMessage();
		}
	
	}
	
	
	// check if all links on the page are OK
	public void verifyPageLinks() {
		List<WebElement> allLinks = findAllLinks(driver);
		log("Amount of all links and images with link: " + allLinks.size());
		for (WebElement element : allLinks) {
			try {
				if (!"200".equals(isLinkBroken(new URL(element.getAttribute("href"))))) {
					log("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
				}
				// to show all tested links
				else {
					log("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
				}
			}
			catch(Exception e) {
				log("At " + element.getAttribute("innerHTML") + " Exception occured " + e.getMessage());
			}
		}
	}
	
	
	public List<WebElement> getAllTextItems() {
	    List<WebElement> body = driver.findElements(By.tagName("body"));
	    for (WebElement element : body) {
	    	log(element.getText());
	    }
	    return body;
	}
	
	
	public boolean isTextOnPagePresent(String text) {
	    WebElement body = driver.findElement(By.tagName("body"));
	    String bodyText = body.getText();
	    log(bodyText);
	    return bodyText.contains(text);
	}
	
	
	public void highlight(WebElement element) {
		//Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px groove green'", element);
		//js.executeScript("arguments[0].style.border=''", element); - to clear highlight
	}
	
	
	public void highlight(List<WebElement> elementList) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		log("Amount of items to highlight = " + elementList.size());
		for (WebElement element : elementList) {
			js.executeScript("arguments[0].style.border='5px groove green'", element);
			log("Done");
		}
        
	}
	
	
	
}
