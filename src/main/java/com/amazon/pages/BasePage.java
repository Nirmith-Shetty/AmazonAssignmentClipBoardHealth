package com.amazon.pages;

import com.amazon.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;

    public BasePage(){
        driver= DriverManager.getInstance().getDriver();
    }

    public void waitForElement(WebElement ele){
        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }


    public void scrollTillElement(WebElement ele){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",ele);
    }

    public void scrollByPixel(int pixel){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixel+")");
    }

    public void switchToNewWindow(){
        String parentWindow=driver.getWindowHandle();
       Set<String> handles =driver.getWindowHandles();

       for(String handle : handles){
           if(parentWindow != handle ){
               driver.switchTo().window(handle);
           }
       }
    }
}
