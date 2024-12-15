package com.example.MyMagentoProject.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategorySelection {
	
	private WebDriver driver;
	
	public CategorySelection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	@FindBy(xpath = "//div[@id='store.menu']/nav/ul/li/a") 
	List<WebElement> categories;
	
	@FindBy(xpath = "//*[@class='categories-menu']/strong[1]/following-sibling::ul/li") 
	List<WebElement> subCategories;
	
	@FindBy(xpath="//button[@title='Add to Cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement showCartIcon;
	
	@FindBy(xpath="//a[@class='action viewcart']")
	WebElement viewandEditCart;
	
	@FindBy(xpath="//div[@class='products wrapper grid products-grid']/ol/li/div/a[@class='product photo product-item-photo']")
	List<WebElement> productName;

	@FindBy(xpath="//div[@role='alert']")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//div[@role='alert']/div/div/a")
	WebElement shoppingCartLink;
	
	/*
	 * public WebElement getCategory(String categoryName) { for (WebElement category
	 * : categories) { if (category.getText().equalsIgnoreCase(categoryName)) {
	 * return category; } } throw new RuntimeException("Category not found: " +
	 * categoryName); }
	 */
	
	@FindBy(xpath="//a[contains(@class,'product photo product-item-photo')]/span/span/img[contains(@alt,'Proteus Fitness Jackshirt')]")
	WebElement getProductName;
	
	
	
	public List<WebElement> getProductNames() {
		// Wait for the product list to be visible 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='products wrapper grid products-grid']//ol/li/div/a")));
		return productName;
		}
	
	public WebElement getProductName(String productName) {
		return driver.findElement(By.xpath("//a[contains(@class,'product photo product-item-photo')]/span/span/img[contains(@alt,'"+productName+"')]"));
		
	}
	
	public WebElement getCategory(String categoryName) {
		return driver.findElement(By.xpath("//div[@id='store.menu']/nav/ul/li/a/span[contains(text(),'"+categoryName+"')]")); 
		}
	
	public WebElement getSubCategory(String subCategoryName) {
		return driver.findElement(By.xpath("//a[text()='" + subCategoryName + "']")); 
		}
	
	public WebElement getMenuItem(String itemName) {
		return driver.findElement(By.xpath("//div[@class='categories-menu']/ul/li/a[contains(text(),'"+itemName+"')]"));
	}
	
	public WebElement getItemSize(String itemSize) {
		return driver.findElement(By.xpath("//div[@class='swatch-opt']/div[@class='swatch-attribute size']/div/child::div[text()='" + itemSize +"']"));
	}
	
	public WebElement getItemColor(String itemColor) {
		return driver.findElement(By.xpath("//div[@class='swatch-opt']/div[@class='swatch-attribute color']/child::div/div[@option-label='" + itemColor +"']"));
		
		
	}
	
	public WebElement cartButton() {
		return addToCartButton;
		
	}
	
	public WebElement cartViewLink() {
		return showCartIcon;
	 	
	}
	
	public WebElement addToCartMessage() {
		return addToCartMessage;
		
	}
	
	public WebElement linkShoppingCart() {
		return shoppingCartLink;
		
	}
	


}
