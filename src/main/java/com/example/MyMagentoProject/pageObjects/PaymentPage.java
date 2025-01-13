package com.example.MyMagentoProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.MyMagentoProject.utilities.HelperUtils;

public class PaymentPage {

	private WebDriver driver;
	private String total;
	private String shippingTotal;
	
	
	@FindBy(xpath="//button[@title='Place Order']")
	WebElement btnPlaceOrder;
	
	//sucsess page
	@FindBy(xpath="//a[@class='order-number']")
	WebElement orderNumber;
	
	@FindBy(xpath="//a[@class='action primary continue']")
	WebElement btnContinueShopping;
	
	@FindBy(xpath="//div[@class='opc-block-summary']/table/tbody/tr/td/span[@data-th='Cart Subtotal']")
	WebElement cartSubTotal;
	
	@FindBy(xpath="//div[@class='opc-block-summary']/table/tbody/tr/td/span[@data-th='Shipping']")
	WebElement shippingPrice;
	
	@FindBy(xpath="//td[@data-th='Order Total']")
	WebElement orderTotal;
	
	@FindBy(xpath="//h1/span[contains(text(),'Thank you')]")
	WebElement orderPlacedMessage;

	public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public WebElement placeOrder() { 
		return btnPlaceOrder;
		
	}
	
	public double subTotal() {
		HelperUtils.waitForElementToBeVisible(driver, cartSubTotal, 3);
		String amount = cartSubTotal.getText();
		total = amount.replace("$", "").trim();
		double subAmount = Double.parseDouble(total);
		return subAmount;
		
	}
	
	public double shippingPrice() {
		HelperUtils.waitForElementToBeVisible(driver, shippingPrice, 3);
		String shippingCost = shippingPrice.getText();
		shippingTotal = shippingCost.replace("$", "").trim();
		double shippinPrice = Double.parseDouble(shippingTotal);
		return shippinPrice;
		
	}
	
	public WebElement orderNum() {
		return orderNumber;
		
	}
	
	public WebElement orderPlacedMessage() {
		return orderPlacedMessage;
		
	}
	
	public WebElement buttonContinue() {
		return btnContinueShopping;
		
	}
	
	
	
}
