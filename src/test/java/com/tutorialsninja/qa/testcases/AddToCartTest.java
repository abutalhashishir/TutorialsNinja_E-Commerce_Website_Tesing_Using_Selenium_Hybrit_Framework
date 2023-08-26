package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AddToCartPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class AddToCartTest extends Base {
	
	SearchPage searchPage;
	HomePage homePage;
	
	public AddToCartTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void AddToCartProduct() {

		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		addToCartPage.AddToCartItem(dataProp.getProperty("quantity"));
		
		Assert.assertTrue(addToCartPage.retriveAddToCartSuccessMessage().contains(dataProp.getProperty("addToCartSuccessfullyHeading")), "Add to Cart Product is not displayed in the search results");
	}
	
	
}
