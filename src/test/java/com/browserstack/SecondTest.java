package com.browserstack;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecondTest {
    boolean present;
    @Test
    public void test() throws Exception {
        //Setting up of drivers
        System.setProperty("webdriver.chrome.driver", "/Users/cormac/Documents/Resources/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        //Amazon
        driver.manage().window().maximize();
        driver.get("https://www.amazon.co.uk/");
        Thread.sleep(2000);

        // Remove the banner at the bottom and enter iphonex into the search bar

        driver.findElement(By.cssSelector("#sp-cc-accept")).click();
        driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("iPhone X", Keys.ENTER);
        Thread.sleep(1000);

        // Select iOS
        driver.findElement(By.cssSelector("ul:nth-of-type(4) > li:nth-of-type(2) .a-icon.a-icon-checkbox")).click();
        Thread.sleep(1000);

        // Go to dropdown and select Price: High to Low
        Select SELECTED = new Select(driver.findElement(By.cssSelector("select#s-result-sort-select")));
        SELECTED.selectByVisibleText("Price: High to Low");

        Thread.sleep(1000);
         //// WE ARE WORKING UNTIL HERE NOW
        // Get WebElements and loop through each element and print the required contents
        List<WebElement> results = driver.findElements(By.cssSelector("div[data-component-type='s-search-result']"));

        for (WebElement result : results) {
            // Get elements
            try {
                String PRODUCT_NAME = result.findElement(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")).getText();
                String PRICE = result.findElement(By.cssSelector(".a-price")).getText();
                String REFERENCE_LINK = result.findElement(By.cssSelector("a.a-link-normal.a-text-normal")).getAttribute("href");
                System.out.println(PRODUCT_NAME);
                System.out.println(PRICE);
                System.out.println(REFERENCE_LINK);
            } catch (NoSuchElementException e) {
                continue;
            }
        }
        //Exit runtime
        driver.quit();

    }
}