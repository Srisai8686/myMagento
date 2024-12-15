package com.example.MyMagentoProject.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HelperUtils {

    // Browser Actions
    public static void takeScreenshot(WebDriver driver, String filePath) {
        // Convert web driver object to TakeScreenshot 
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        // Call getScreenshotAs method to create image file 
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE); 
        // Move image file to the specified location 
        try {
            FileUtils.copyFile(srcFile, new File(filePath));
        } 
        catch (IOException e) {
            e.printStackTrace(); 
        } 
    }
    
    public static void click(WebDriver driver, WebElement element) {
        try {
            waitForElementToBeClickable(driver, element, Duration.ofSeconds(10)).click();
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "clickError");
            throw e;
        }
    }

    public static void sendKeys(WebDriver driver, WebElement element, String text) {
        try {
            waitForElementToBeVisible(driver, element, Duration.ofSeconds(10)).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "sendKeysError");
            throw e;
        }
    }

    public static void hover(WebDriver driver, WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "hoverError");
            throw e;
        }
    }

    public static String getText(WebDriver driver, WebElement element) {
        try {
            return waitForElementToBeVisible(driver, element, Duration.ofSeconds(10)).getText();
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "getTextError");
            throw e;
        }
    }

    // Waits
    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, Duration timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "waitForElementToBeClickableError");
            throw e;
        }
    }

    // Overloaded method to wait for an element to be clickable with int timeout
    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "waitForElementToBeClickableError");
            throw e;
        }
    }

    // Overloaded method to wait for an element to be visible with int timeout
    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "waitForElementToBeVisibleError");
            throw e;
        }
    }

    // Original method to wait for an element to be visible with Duration timeout
    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element, Duration timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "waitForElementToBeVisibleError");
            throw e;
        }
    }

    public static void waitForPageTitle(WebDriver driver, String title, Duration timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.titleIs(title));
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "waitForPageTitleError");
            throw e;
        }
    }

    // JavaScript Executor
    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "scrollToElementError");
            throw e;
        }
    }

    public static void clickElementByJS(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "clickElementByJSError");
            throw e;
        }
    }

    public static void setAttributeByJS(WebDriver driver, WebElement element, String attributeName, String value) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, value);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot(driver, "setAttributeByJSError");
            throw e;
        }
    }

    // Assertions
    public static void assertElementIsVisible(WebDriver driver, WebElement element) {
        try {
            WebElement visibleElement = waitForElementToBeVisible(driver, element, Duration.ofSeconds(10));
            Assert.assertTrue(visibleElement.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
