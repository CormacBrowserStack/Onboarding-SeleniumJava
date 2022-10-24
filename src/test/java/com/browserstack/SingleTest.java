package com.browserstack;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    @Test
    public void test() throws Exception {
    	  // navigate to bstackdemo
        //Selenium Test Script
        driver.manage().window().maximize();
        driver.get("https://www.bstackdemo.com/");
        driver.findElement(By.cssSelector("a#signin")).click();

        Thread.sleep(1000);

        //Select login options and log in
        driver.findElement(By.cssSelector("#username input")).sendKeys("demouser" + Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#password input")).sendKeys("testingisfun99" +Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#login-btn")).click();
        Thread.sleep(2000);

        //Add button to the cart
        driver.findElement(By.cssSelector("div:nth-of-type(2) > .shelf-item__buy-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".buy-btn")).click();
        Thread.sleep(1000);

        //button#checkout-shipping-continue
        driver.findElement(By.cssSelector("input#firstNameInput")).sendKeys("Cormac" + Keys.ENTER);
        driver.findElement(By.cssSelector("input#lastNameInput")).sendKeys("Demo" + Keys.ENTER);
        driver.findElement(By.cssSelector("input#addressLine1Input")).sendKeys("DogPatch HQ Dublin" + Keys.ENTER);
        driver.findElement(By.cssSelector("input#provinceInput")).sendKeys("Leinster" + Keys.ENTER);
        driver.findElement(By.cssSelector("input#postCodeInput")).sendKeys("EIRCODE" + Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button")).click();

        // Confirm and Assert
        System.out.println("Cormac");
        String placed = driver.findElement(By.cssSelector("legend#confirmation-message")).getText();

        if (placed.eq("Your Order has been successfully placed.", placed)){
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"<passed>\", \"reason\": \"Confirmation message matches"\}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Confirmation message doesn't match\"}}");
        }


        Thread.sleep(10000);

        Assert.assertEquals("Your Order has been successfully placed.", placed);
        Thread.sleep(1000);
        //Exit runtime
        driver.quit();
    }
}
