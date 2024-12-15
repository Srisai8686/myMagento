package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.example.MyMagentoProject.pageObjects.LoginPage;
import com.example.MyMagentoProject.utilities.ConfigReader;
import com.example.MyMagentoProject.utilities.DriverManager;
import com.example.MyMagentoProject.utilities.HelperUtils;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ConfigReader configReader;
 
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = DriverManager.getDriver();
        configReader = new ConfigReader();
        driver.get(configReader.getProperty("baseUrl"));
        loginPage = new LoginPage(driver);
        HelperUtils.click(driver, loginPage.getSignInLink());
        //loginPage.clickSignInLink();
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
    	String username = configReader.getDecryptedProperty("encodedUsername");
    	String password = configReader.getDecryptedProperty("encodedPassword");
    	HelperUtils.sendKeys(driver, loginPage.getEmailField(), username);
    	HelperUtils.sendKeys(driver, loginPage.getPasswordField(), password);
    	HelperUtils.click(driver, loginPage.getSignInButton());
        //loginPage.enterEmail(username);
        //loginPage.enterPassword(password);
        //loginPage.clickSignIn();
    }

    @Then("I should be redirected to the homepage")
    public void i_should_be_redirected_to_the_homepage() throws InterruptedException {
        //assert loginPage.isDashboardDisplayed();
		/*
		 * String message = loginPage.successMessage(); Thread.sleep(3000);
		 * if(message.contains("Welcome")) { System.out.println("user "+
		 * configReader.getDecryptedProperty("encodedUsername")+
		 * " has sucessfully logged in"); } DriverManager.quitDriver();
		 */
    	HelperUtils.waitForElementToBeVisible(driver, loginPage.successMessage(), Duration.ofSeconds(5));
    	String message = HelperUtils.getText(driver, loginPage.successMessage());
    	if(message.contains("Welcome")) {
    		System.out.println("user "+
    			 configReader.getDecryptedProperty("encodedUsername")+ " has sucessfully logged in"); 
    		}
    	HelperUtils.takeScreenshot(driver, "loginSuccess");
    	DriverManager.quitDriver();
    }
}
