package main.java.application.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Footer {
	private WebDriver driver;
	
	
	// Desktop Footer links
	By legalFooterLink = By.xpath("//div[@class='menu']//div[@class='link']/a/span[@class='title' and text()='Legal']/ancestor::a[1]");
	By sitemapFooterLink = By.xpath("//div[@class='menu']//div[@class='link']/a/span[@class='title' and text()='Sitemap']/ancestor::a[1]");
	By investorsFooterLink = By.xpath("//div[@class='menu']//div[@class='link']/a/span[@class='title' and text()='Investors']/ancestor::a[1]");
	By careersFooterLink = By.xpath("//div[@class='menu']//div[@class='link']/a/span[@class='title' and text()='Careers']/ancestor::a[1]");
	By newsletterFooterLink = By.xpath("//div[@class='menu']//div[@class='link']/a/span[@class='title' and text()='Newsletter']/ancestor::a[1]");
	By textViewFooterLink = By.xpath("//div[@class='menu']//div[@class='link']/a/span[@class='title' and text()='Text View']/ancestor::a[1]");
	
	
	
	
	
	public Footer(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	
	
}
