package com.amazon.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    WebDriver driver;
    public static DriverManager instance = null;

    private DriverManager() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
