package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TelevisionAndEntertainmentPage extends BasePage{

    public TelevisionAndEntertainmentPage(){
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.XPATH, using ="//div[@id='s-refinements']//following::span[text()='Brands']//following::span[text()='Samsung']")
    private WebElement SelectSamsungBrand;

    public SamsungTVPage clickOnSamsungBrand(){
        waitForElement(SelectSamsungBrand);
        scrollTillElement(SelectSamsungBrand);
        SelectSamsungBrand.click();
        return new SamsungTVPage();
    }
}
