package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EndToEndPage {
	
	
WebDriver driver;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement continueBTN;
	//a[normalize-space()='Qafox.com']
	
	@FindBy(xpath = "//a[normalize-space()='Qafox.com']")
	private WebElement TittleHeading;
	
	public EndToEndPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void goHomePage() throws InterruptedException {
		Thread.sleep(2000);
		continueBTN.click();
	}
	
	public String homePageHeading() {
		
		String homePageHeadingText = TittleHeading.getText();
		return homePageHeadingText;

	}
	
}
