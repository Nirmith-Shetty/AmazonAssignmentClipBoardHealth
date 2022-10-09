package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//span[@id='productTitle']")
    private WebElement productTileLabel;

    @FindBy(how = How.XPATH, using = "//h1[text()=' About this item ']")
    private WebElement AboutThisItemLabel;

    public String getProductName() {
        return productTileLabel.getText();
    }

    public void scrollToAboutThisItemLabel() {
        scrollByPixel(250);
        scrollTillElement(AboutThisItemLabel);

    }
}
