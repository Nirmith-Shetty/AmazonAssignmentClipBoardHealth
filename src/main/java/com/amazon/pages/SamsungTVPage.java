package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SamsungTVPage extends BasePage {

    public SamsungTVPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//select[@id='s-result-sort-select']")
    private WebElement selectSortFilter;

    @FindBy(how = How.XPATH, using = "//img[@data-image-index='2']")
    private WebElement secondHighestPrice;


    public void filterSamsungTVByPrice(String type) {
        Select sel = new Select(selectSortFilter);
        sel.selectByVisibleText(type);
    }

    public String getFirstSeletedOption() {
        Select sel = new Select(selectSortFilter);
        return sel.getFirstSelectedOption().getText();
    }

    public ProductDetailPage ClickOnSecondImage(){
        secondHighestPrice.click();
        switchToNewWindow();
        return new ProductDetailPage();
    }
}


