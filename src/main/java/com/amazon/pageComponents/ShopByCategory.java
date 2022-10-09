package com.amazon.pageComponents;

import com.amazon.pages.BasePage;
import com.amazon.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShopByCategory extends BasePage implements HamBurgerMenu {

    WebDriver driver;

    public ShopByCategory() {
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[text()='TV, Appliances, Electronics']")
    WebElement TVAppliancesLabel;

    @Override
    public SubCategory clickOnCategory(String category) {

        switch (category) {
            case "TV, Appliances, Electronics":
                waitForElement(TVAppliancesLabel);
                TVAppliancesLabel.click();
                return new TVAudioCameraSubCategory();
            default:
                System.out.println("This Category is not defined");
                break;
        }

        return null;
    }
}
