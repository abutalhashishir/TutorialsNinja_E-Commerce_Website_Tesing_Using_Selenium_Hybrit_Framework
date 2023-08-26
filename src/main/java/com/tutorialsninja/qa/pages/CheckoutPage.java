package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
		
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "button-login")
	private WebElement loginBTN;
	
	@FindBy(id = "button-payment-address")
	private WebElement paymentAddressBTN;
	
	@FindBy(id = "button-shipping-address")
	private WebElement shippingAddressBTN;	
	
	@FindBy(id = "button-shipping-method")
	private WebElement shippingMethodBtN;
	
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement radioBtN;
	
	
	@FindBy(id = "button-payment-method")
	private WebElement paymentMethodBTN;
	
	@FindBy(id = "button-confirm")
	private WebElement confirmOrderBTN;
	
	@FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
	private WebElement confirmOrderSuccessHeading;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void checkoutPageFilup(String validEmailText, String validPasswordText) throws InterruptedException {
		emailField.sendKeys(validEmailText);
		passwordField.sendKeys(validPasswordText);
		Thread.sleep(2000);
		loginBTN.click();
		Thread.sleep(2000);
		paymentAddressBTN.click();
		Thread.sleep(2000);
		shippingAddressBTN.click();
		Thread.sleep(2000);
		shippingMethodBtN.click();
		Thread.sleep(2000);
		radioBtN.click();
		paymentMethodBTN.click();
		Thread.sleep(2000);
		confirmOrderBTN.click();
	}
	
	public String CheckOutSuccessMessage() {
		
		String confirmOrderSuccessHeadingText = confirmOrderSuccessHeading.getText();
		return confirmOrderSuccessHeadingText;

	}

}