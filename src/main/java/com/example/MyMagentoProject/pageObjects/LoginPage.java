package com.example.MyMagentoProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    // Define locators using @FindBy annotation
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    private WebElement signInLink;
    
    @FindBy(id = "send2")
    private WebElement signInButton;

    @FindBy(className = "dashboard")
    private WebElement accountDashboard;
    
    @FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[1]/span")
    private WebElement loginSucess;
    

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    public WebElement getEmailField() {
		return emailField;
    	
    }
    public WebElement getPasswordField() {
		return passwordField;
    	
    }
    
    public WebElement getSignInButton() {
		return signInButton;
    	
    }
    
    public WebElement getSignInLink() {
		return signInLink;
    	
    }
    
	/*
	 * // Define actions public void enterEmail(String email) {
	 * emailField.sendKeys(email); }
	 * 
	 * public void enterPassword(String password) {
	 * passwordField.sendKeys(password); }
	 * 
	 * public void clickSignIn() { signInButton.click(); }
	 * 
	 * public void clickSignInLink() { signInLink.click(); }
	 * 
	 * public boolean isDashboardDisplayed() { return
	 * accountDashboard.isDisplayed(); }
	 */
	  public WebElement successMessage() {
		  return loginSucess;
	  }
	 
}
