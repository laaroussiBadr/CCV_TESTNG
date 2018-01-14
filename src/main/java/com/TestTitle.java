package com;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

import com.pages.HomePage;
import com.pages.SearchPage;
import com.utils.MyWebDriver;


public class TestTitle {
	private WebDriver driver = null;
	
	HomePage homePage;
	SearchPage searchPage;
	
	@Test(priority=1, groups="searchItems")
	@Parameters({ "myURL" })
	public void openCCVModeHomePage(String myURL) {
		driver.get(myURL);
		homePage = new HomePage(driver);
	}
	
	@Test(priority=2, groups="searchItems", dependsOnMethods= {"openCCVModeHomePage"})
	@Parameters({"itemToSearch"})
	public void searchForAnItem(String itemToSearch) {
		searchPage = homePage.searchForAnItem(itemToSearch);
	}
	
	@Test(priority=3, groups="filterSearchResults", dependsOnGroups={"searchItems"})
	public void filterTheSearchResult() {
		int searchResultCounter = searchPage.getSearchResultCounter();
		
		searchPage.filterByGroup("Homme");
		searchPage.waitForResetFilter();
		
		int searchResultCounterAfter = searchPage.getSearchResultCounter();
				
		Assert.assertTrue(searchResultCounter > searchResultCounterAfter);
	}
	
	@BeforeTest(groups="searchItems")
	public void beforeTest() throws Exception {
		driver = MyWebDriver.getInstanceOfSingletonBrowserClass().getDriver();	}

	@AfterTest(groups="searchItems")
	public void afterTest() {
		driver.quit();
	}

}
