package com.example.MyMagentoProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
	private WebDriver driver;
	
	@FindBy(xpath="/button[@class='action action-show-popup']")
	WebElement btnNewAddress;
	
	@FindBy(xpath="//button[@class='button action continue primary']")
	WebElement btnNext;
		
	@FindBy(xpath="//input[@name='ko_unique_1']")
	WebElement shippingMethodRadioBtn1;
	
	@FindBy(xpath="//input[@name='ko_unique_2']")
	WebElement shippingMethodRadioBtn2;
	
	@FindBy(xpath="//button[@class='action primary action-save-address']")
	WebElement btnShipHere;
	
	@FindBy(xpath="//button[@class='action secondary action-hide-popup']")
	WebElement btnCancel;
	
	@FindBy(xpath="//input[@name='company']")
	WebElement txtFieldCompany;
	
	@FindBy(xpath="//input[@name='street[0]']")
	WebElement txtFieldStreet;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement txtFieldCity;
	
	@FindBy(xpath="//select[@name='region_id']")
	WebElement ddState;
	
	@FindBy(xpath="//input[@name='postcode']")
	WebElement txtFieldPostCode;
	
	@FindBy(xpath="//select[@name='country_id']")
	WebElement ddCountry;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement txtFieldTelephone;
	
	@FindBy(xpath="//span[contains(text(),'Save in address book')]")
	WebElement chckBoxSaveAdressBook;
	
	@FindBy(xpath="//span[@class='cart-price']/span")
	WebElement itemPrice;
	
	@FindBy(xpath="//*[@id='checkout-shipping-method-load']/table/tbody/tr[2]/td[2]/span/span")
	WebElement fixedRate;
	
	@FindBy(xpath="//*[@id='checkout-shipping-method-load']/table/tbody/tr[1]/td[2]/span/span")
	WebElement tableRate;
	
	@FindBy(xpath="//*[@id='opc-sidebar']/div[1]/div/div[1]/strong")
	WebElement expandItems;


	
	
	 public ShippingPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 public WebElement getItemPrice() {
		return itemPrice;
		 
	 }
	 
	 
	 
	 public WebElement clickNext() {
		return btnNext;
		 
	 }
	 
	 public WebElement shippingFlatRdBtn() {
		return shippingMethodRadioBtn1;
		 
	 }
	 
	 public WebElement shippingTableRateRdBtn() {
		return shippingMethodRadioBtn2;
		 
	 }
	 
	 public WebElement shippingFlatRate() {
		return fixedRate;
		 
	 }
	 
	 public WebElement shippingTableRate() {
		return tableRate;
		 
	 }
	 
	 public WebElement returnCartItems() {
		return expandItems;
		 
	 }
	 
}
