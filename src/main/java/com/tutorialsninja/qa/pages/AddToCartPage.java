package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddToCartPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	private WebElement addToCart;
		
	@FindBy(id = "input-quantity")
	private WebElement quantity;
	
	@FindBy(id = "button-cart")
	private WebElement addToCartBTN;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement addToCartSuccessHeading;
	
	public AddToCartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	

	public void AddToCartItem(String quantityText) {
		addToCart.click();
	    quantity.clear();
	    quantity.sendKeys(quantityText);
	    addToCartBTN.click();
	    
	}
	
	public String retriveAddToCartSuccessMessage() {
		
		String addToCartSuccessfullyHeadingText = addToCartSuccessHeading.getText();
		return addToCartSuccessfullyHeadingText;

	}


}
