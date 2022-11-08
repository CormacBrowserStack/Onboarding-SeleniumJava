package com.browserstack;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.percy.selenium.Percy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PercyTest extends BrowserStackTestNGTest {
    private static Percy percy;
    @Test
    public void test() throws Exception {
        //Setting up of drivers
        System.setProperty("webdriver.chrome.driver", "/Users/cormac/Documents/Resources/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        percy = new Percy(driver);

        //Expand window and go to Amazon
        driver.manage().window().maximize();
        driver.get("https://k8s.bsstag.com/");
        Thread.sleep(5000);
        percy.snapshot("Homepage");
        driver.get("https://k8s.bsstag.com/pricing");
        Thread.sleep(5000);
        percy.snapshot("Pricing");
        driver.get("https://k8s.bsstag.com/integrations/automate");
        Thread.sleep(5000);
        percy.snapshot("Automate");
        driver.get("https://k8s.bsstag.com/docs");
        Thread.sleep(5000);
        percy.snapshot("Docs");
        //Exit runtime
        driver.quit();

    }
}
