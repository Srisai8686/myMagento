package com.example.MyMagentoProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategorySelection {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//div[@id='store.menu']/nav/ul/li/a") 
	List<WebElement> categories;
	
	@FindBy(xpath = "//*[@class='categories-menu']/strong[1]/following-sibling::ul/li") 
	List<WebElement> subCategories;
	
	@FindBy(xpath="//button[@title='Add to Cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement showCartIcon;
	

	public CategorySelection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public WebElement getCategory(String categoryName) {
		for (WebElement category : categories) {
			if (category.getText().equalsIgnoreCase(categoryName)) {
				return category; 
				}
			} 
		throw new RuntimeException("Category not found: " + categoryName);
	}
	
	public WebElement getSubCategory(String subCategoryName) {
		return driver.findElement(By.xpath("//a[text()='" + subCategoryName + "']")); 
		}
	
	public WebElement getMenuItem(String itemName) {
		return driver.findElement(By.xpath("//div[@class='product-item-details']/strong/a[contains(text(),'" + itemName +"')]"));
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
	


}
