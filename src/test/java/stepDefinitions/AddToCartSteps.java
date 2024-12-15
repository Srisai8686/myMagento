package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import com.example.MyMagentoProject.pageObjects.CategorySelection;
import com.example.MyMagentoProject.pageObjects.CheckoutPage;
import com.example.MyMagentoProject.pageObjects.PaymentPage;
import com.example.MyMagentoProject.pageObjects.ShippingPage;
import com.example.MyMagentoProject.utilities.DriverManager;
import com.example.MyMagentoProject.utilities.HelperUtils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartSteps {
    private WebDriver driver;
    private CategorySelection categorySelection;
    private CheckoutPage checkout;
    private String selectedProductName;
    private String getProductPrice;
    private String getShippingCharge;
    private ShippingPage shipping;
    private double shipCharge;
    private double orderAmount;
    private double TotalOrder;

    public AddToCartSteps() {
        this.driver = DriverManager.getDriver();
        this.categorySelection = new CategorySelection(driver);
        this.checkout = new CheckoutPage(driver);
        this.shipping = new ShippingPage(driver);
        //this.payment = new PaymentPage(driver);
    }

    @And("I navigate to the {string} category")
    public void i_navigate_to_the_category(String category) {
        HelperUtils.waitForElementToBeVisible(driver, categorySelection.getCategory(category), 5);
        HelperUtils.click(driver, categorySelection.getCategory(category));
    }

    @And("I navigate to the subcategory and click on {string}")
    public void i_navigate_to_the_subcategory_and_click_on(String itemType) {
        //HelperUtils.waitForElementToBeVisible(driver, categorySelection.getSubCategory(subcategory), 5);
        //HelperUtils.click(driver, categorySelection.getSubCategory(subcategory));
        HelperUtils.waitForElementToBeVisible(driver, categorySelection.getMenuItem(itemType), 5);
        HelperUtils.click(driver, categorySelection.getMenuItem(itemType));
    }

    @And("I search for the desired jacket by name {string}")
    public String i_search_for_the_desired_jacket_by_name(String product) {
        // Code to search for the jacket by name, if needed
    	//HelperUtils.waitForElementToBeVisible(driver, categorySelection.getProductNames().get(0), 10);
		/*
		 * List<WebElement> products = categorySelection.getProductNames();
		 * 
		 * for (WebElement product : products) { System.out.println(product.getText());
		 * // Find the product name element within the product item //WebElement
		 * productNameElement = product.findElement(By.cssSelector(".product-name")); //
		 * Check if the product name matches the desired product if
		 * (product.getText().equalsIgnoreCase(productName)) {
		 * 
		 * System.out.println(product.getText());
		 * 
		 * 
		 * // If the product is found, click on it HelperUtils.click(driver, product);
		 * break; } }
		 */
    	   
    	   HelperUtils.waitForElementToBeVisible(driver, categorySelection.getProductName(product), 5);
           HelperUtils.click(driver, categorySelection.getProductName(product));
           selectedProductName = product;
    	   return product;
    
    }

    @And("I select size {string} and color {string}")
    public void i_select_size_and_color(String size, String color) {
        HelperUtils.waitForElementToBeVisible(driver, categorySelection.getItemSize(size), 5);
        HelperUtils.click(driver, categorySelection.getItemSize(size));
        HelperUtils.waitForElementToBeVisible(driver, categorySelection.getItemColor(color), 5);
        HelperUtils.click(driver, categorySelection.getItemColor(color));
    }

    @And("I click on the {string} button")
    public void i_click_on_the_button(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            HelperUtils.waitForElementToBeClickable(driver, categorySelection.cartButton(), 5);
            HelperUtils.click(driver, categorySelection.cartButton());
		} /*
			 * else if (buttonName.equals("View/Edit Cart")) {
			 * HelperUtils.waitForElementToBeClickable(driver,
			 * categorySelection.cartViewLink(), 5); HelperUtils.click(driver,
			 * categorySelection.cartViewLink()); }
			 */
    }

    @Then("I should see the desired jacket in the cart")
    public void i_should_see_the_desired_jacket_in_the_cart() {
    	
    	String itemInCart = HelperUtils.getText(driver, checkout.verifydressAttributes(selectedProductName));
    	
    	//System.out.println("product in cart is:"+itemInCart);
    
    	if(selectedProductName.equals(itemInCart)) {
    		System.out.println("The product is in the cart: " + selectedProductName);
    		} else
    		{
    			System.out.println("The product is NOT in the cart: " + selectedProductName); 
    			}
    	}
    	
    	
    @Then("Verify the success message product added to cart")
    public void verify_the_success_message_product_added_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        String addToCartMsg = HelperUtils.getText(driver, categorySelection.addToCartMessage());
        
        if(addToCartMsg.contains("You added")) {
        	System.out.println("Sucess Message is "+ addToCartMsg);
        }
        else {
        	System.out.println("No success Message displayed");
        }
        
        
    }
    @Then("I click on the cart icon")
    public void i_click_on_the_cart_icon() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	HelperUtils.click(driver, categorySelection.linkShoppingCart());
    }
    @Then("click on proceed to checkout page")
    public void click_on_proceed_to_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	HelperUtils.click(driver, checkout.clickProccedToCheckoutBtn());
    }
    @Then("select desired Shipping methods")
    public double select_desrired_shipping_methods() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();)
    	HelperUtils.click(driver, shipping.shippingTableRate());	
    	String shippingCharge = HelperUtils.getText(driver, shipping.shippingTableRate());
    	System.out.println("shippingCharge is:"+shippingCharge);
    	getShippingCharge=shippingCharge.replace("$", "").trim();
    	
    	if (getShippingCharge.isEmpty()) {
    		throw new NumberFormatException("Shipping charge string is empty");
    		}
    	double shipCharge = Double.parseDouble(getShippingCharge);
    	return shipCharge;
    }
    @Then("order summary get the order amount")
    public double order_summary_get_the_order_amount() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	HelperUtils.click(driver, shipping.returnCartItems());
    	HelperUtils.waitForElementToBeVisible(driver, shipping.getItemPrice(), 5);
    	String itemPrice =HelperUtils.getText(driver, shipping.getItemPrice());
    	getProductPrice = itemPrice.replace("$", "").trim();
    	double orderAmount = Double.parseDouble(getProductPrice);
    	System.out.println(orderAmount);
    	return orderAmount;
    	
    }
    @Then("click Next and verify order total shiping amount is added to order amount")
    public double click_next_and_verify_order_total_shiping_amount_is_added_to_order_amount() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	HelperUtils.click(driver, shipping.clickNext());
    	
    	double TotalOrder = shipCharge+orderAmount;
    	System.out.println(TotalOrder);
    	return TotalOrder;
    	
    	
    	
    }
    @Then("click on place order and verify the order purchase message and order number")
    public void click_on_place_order_and_verify_the_order_purchase_message_and_order_number() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	
    	PaymentPage payment = new PaymentPage(driver);
    	double cartTotal = payment.subTotal();
    	double shipPrice = payment.shippingPrice();
    	double totalItemPrice = cartTotal+shipPrice;
    	
    	System.out.println("Amount is:"+totalItemPrice);
    	
    	if(totalItemPrice==TotalOrder) {
    		System.out.println("The amounts are equal.");
    	}
    	else {
    		System.out.println("The amounts are not equal"+"because"+totalItemPrice+"&&"+TotalOrder);
    	}
    	
    	HelperUtils.click(driver, payment.placeOrder());
    	
    	String message = HelperUtils.getText(driver, payment.orderPlacedMessage());
    	if(message.contains("Thank you")) {
    		System.out.println("order placed succesfully");
    	}
    	
    	String orderNum = HelperUtils.getText(driver, payment.orderNum());
    	System.out.println("order number is:"+orderNum);
    }
    
    
}
