package com.amazon.pageComponents;

import com.amazon.pages.BasePage;
import com.amazon.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TVAudioCameraSubCategory extends BasePage implements SubCategory{

    WebDriver driver;

    public TVAudioCameraSubCategory(){
        driver= DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.LINK_TEXT, using ="Televisions")
    private WebElement TelevisionsLink;

    @Override
    public SubCategory clickOnSubCategory(String category) {

        switch (category) {
            case "Televisions":
                waitForElement(TelevisionsLink);
                TelevisionsLink.click();
                return new TVAudioCameraSubCategory();
            default:
                System.out.println("This Category is not defined");
                break;
        }
       return null;
    }
}
