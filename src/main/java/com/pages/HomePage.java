package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	String pageTitle = "CCV Vêtements et Chaussures, Mode femme, mode homme, mode enfant";
	
	By searchInput = By.xpath("//input[@name='search_query']");
	By searhButton = By.xpath("//button[@name='submit_search']");
	
	public HomePage(WebDriver driver) throws IllegalStateException {
		this.driver = driver;
		if(!driver.getTitle().equals(pageTitle)) {
			throw new IllegalStateException("Le titre de la page est différent de " + pageTitle);
		}
	}
	
	public SearchPage searchForAnItem(String itemToSearch) {
		driver.findElement(searchInput).sendKeys(itemToSearch);
		driver.findElement(searhButton).click();
		
		return new SearchPage(driver);
	}
	
}
