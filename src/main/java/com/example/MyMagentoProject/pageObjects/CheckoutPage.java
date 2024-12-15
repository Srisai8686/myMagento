package com.example.MyMagentoProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	private WebDriver driver;
	
	 public CheckoutPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	@FindBy(xpath="//tbody[@class='cart item']/tr/td/div/strong/a[text()='Taurus Elements Shell']")
	WebElement checkoutItems;
	
	@FindBy(xpath="//dl[@class='item-options']/dd")
	WebElement dressAttributes;
	
	@FindBy(xpath="//button[@title='Update Shopping Cart']")
	WebElement btnUpdateCart;
	
	@FindBy(xpath="//button[@data-role='proceed-to-checkout']")
	WebElement btnProceedToCheckout;
	
	@FindBy(xpath="//div[@class='actions-toolbar']/a/span[contains(text(),'Edit')]")
	WebElement editoption;
	//
	@FindBy(xpath="//div[@class='actions-toolbar']/a/span[contains(text(),'Remove')]")
	WebElement deleteOption;
	
	
	public WebElement getItemPrice(String itemPrice) {
		return driver.findElement(By.xpath("//td[@class='col price']/span/span/span[contains(text(),'"+itemPrice +"')]")); 
		}
	
	public WebElement getSubTotal(String subTotal) {
		return driver.findElement(By.xpath("//td[@class='col price']/span/span/span[contains(text(),'"+subTotal +"')]")); 
		}
	
	public WebElement verifyCartItems(String addedItems) {
		return driver.findElement(By.xpath("//tbody[@class='cart item']/tr/td/div/strong/a[text()='"+addedItems+"']")); 
		
		}
	public WebElement verifydressAttributes(String itemAttributes) {
		return driver.findElement(By.xpath("//tbody[@class='cart item']/tr/td/div/strong/a[text()='"+itemAttributes+"']")); 
		
		}
	
	public WebElement clickProccedToCheckoutBtn() {
		return btnProceedToCheckout;
		
	}
	
	
}
