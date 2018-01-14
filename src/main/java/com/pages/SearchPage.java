package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	By productListGrid    = By.xpath("//ul[@class='product_list grid row']");
	By headingCounter     = By.xpath("//*[@id='center_column']//span[@class='heading-counter ']");
	By menGroup 	      = By.xpath("//*[@id='layered_id_feature_group_160']");
	By resetFiltersButton = By.xpath("//*[@id='enabled_filters']/span[2]/a");
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(productListGrid));
	}
	
	public int getSearchResultCounter() {
		wait.until(ExpectedConditions.presenceOfElementLocated(headingCounter));
		String searchResult = driver.findElement(headingCounter).getText();
		return Integer.parseInt(searchResult.split(" ")[0]);
	}
	
	public void filterByGroup(String group) {
		if(group.equalsIgnoreCase("Homme")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(menGroup));
			driver.findElement(menGroup).click();
		}
	}
	
	public void waitForResetFilter() {
		wait.until(ExpectedConditions.presenceOfElementLocated(resetFiltersButton));
	}
	
}
