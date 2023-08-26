package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	private WebElement shoppingCartBTN;
		
	@FindBy(xpath = "//a[normalize-space()='Estimate Shipping & Taxes']")
	private WebElement estimateShipping;
	
	@FindBy(id = "input-country")
	private WebElement countryField;
	
	@FindBy(id = "input-zone")
	private WebElement stateField;
	
	@FindBy(id = "input-postcode")
	private WebElement postalCodeField;	
	
	@FindBy(id = "button-quote")
	private WebElement quoteBtN;
	
	
	@FindBy(name = "shipping_method")
	private WebElement radioBtN;
	
	
	@FindBy(id = "button-shipping")
	private WebElement applyShipping;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement checkOutBTN;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[normalize-space()='Checkout']")
	private WebElement checkOutPageHeading;
	
	public ShoppingCartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void ShoppingPageFilup(String postalCodeText) throws InterruptedException {
		shoppingCartBTN.click();
		estimateShipping.click();
		Select countrySelect = new Select(countryField);
	    countrySelect.selectByValue("18");
	    Thread.sleep(1000);
	    Select stateSelect = new Select(stateField);
	    stateSelect.selectByValue("322");
	    Thread.sleep(1000);
	    postalCodeField.clear();
	    postalCodeField.sendKeys(postalCodeText);
	    quoteBtN.click();
	    Thread.sleep(1000);
	    radioBtN.click();
	    applyShipping.click();
	    Thread.sleep(1000);
	    checkOutBTN.click();
	    
	}
	
	public String shoppingCartSuccessMessage() {
		
		String shoppingCartSuccessHeadingText = checkOutPageHeading.getText();
		return shoppingCartSuccessHeadingText;

	}

}
