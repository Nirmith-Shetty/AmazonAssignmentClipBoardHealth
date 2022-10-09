package com.amazon.tests;

import com.amazon.pages.*;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(AmazonTests.class)
public class AmazonTests extends BaseTest {

    @Test(priority = 1)
    public void verifySuccessfulNavigationToAmazonPage() throws IOException {
        test = extent.createTest("NavigateToAmazonPage");
        test.log(Status.INFO, "launching Amazon page");
        navigateToAmazonPage();
        Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }

    @Test(priority = 2)
    public void verifyTelevisionPageIsDisplayed() {
        test = extent.createTest("verifyTelevisionPageIsDisplayed");
        test.log(Status.INFO, "Navigating to Televisions Page");
        AmazonHomePage homePage = new AmazonHomePage();
        homePage.clickOnHamBurgerMenu()
                .clickOnCategory("TV, Appliances, Electronics")
                .clickOnSubCategory("Televisions");
        Assert.assertEquals(driver.getTitle(), "Buy the latest LED TVs, 4K TVs and Android TVs online at Best Prices in India-Amazon.in | Shop by size, price, features and more");
        Assert.assertTrue(driver.getCurrentUrl().contains("television"));
    }

    @Test(priority = 3)
    public void verifySamsungTelevisionAreOnlyDisplayed() {
        test = extent.createTest("verifySamsungTelevisionAreOnlyDisplayed");
        test.log(Status.INFO, "Selecting brand Samsung under list of televisions");
        TelevisionAndEntertainmentPage Television = new TelevisionAndEntertainmentPage();
        SamsungTVPage samsungTVPage = Television.clickOnSamsungBrand();
        Assert.assertTrue(driver.getCurrentUrl().contains("Samsung"));
        Assert.assertEquals(samsungTVPage.getFirstSeletedOption(), "Featured");
        test.log(Status.INFO, "Sorting list from Price: High to Low");
        samsungTVPage.filterSamsungTVByPrice("Price: High to Low");
        Assert.assertEquals(samsungTVPage.getFirstSeletedOption(), "Price: High to Low");
    }

    @Test(priority = 4)
    public void verifySecondHighestSamsungTVIsDisplayed() {
        test = extent.createTest("verifySecondHighestSamsungTVIsDisplayed");
        SamsungTVPage samsungTVPage = new SamsungTVPage();
        test.log(Status.INFO, "Selecting second highest priced samsung tv");
        ProductDetailPage DetailPage = samsungTVPage.ClickOnSecondImage();
        DetailPage.scrollToAboutThisItemLabel();
    }

}
