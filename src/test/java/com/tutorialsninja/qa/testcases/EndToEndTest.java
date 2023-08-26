package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AddToCartPage;
import com.tutorialsninja.qa.pages.CheckoutPage;
import com.tutorialsninja.qa.pages.EndToEndPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;
import com.tutorialsninja.qa.pages.ShoppingCartPage;

public class EndToEndTest extends Base {
	
	SearchPage searchPage;
	HomePage homePage;
	
	public EndToEndTest() {
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

	}
	
	@Test(priority=1)
	public void EndToEndTestWithAllField() throws InterruptedException {
		
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		EndToEndPage endToEndPage = new EndToEndPage(driver);

		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		
		addToCartPage.AddToCartItem(dataProp.getProperty("quantity"));
		Thread.sleep(1000);
		
		shoppingCartPage.ShoppingPageFilup(dataProp.getProperty("postalCode"));
		
		checkoutPage.checkoutPageFilup(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		
		endToEndPage.goHomePage();
		Assert.assertTrue(endToEndPage.homePageHeading().contains(dataProp.getProperty("homePageHeading")), "homePage is not displayed");
	}
}