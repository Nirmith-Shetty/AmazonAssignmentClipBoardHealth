package com.amazon.pages;

import com.amazon.pageComponents.HamBurgerMenu;
import com.amazon.pageComponents.ShopByCategory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends BasePage {

    public AmazonHomePage(){
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(how=How.ID, using ="nav-hamburger-menu")
    private WebElement HamBurgerMenu;

    public HamBurgerMenu clickOnHamBurgerMenu(){
        HamBurgerMenu.click();
        return new ShopByCategory();
    }

}
