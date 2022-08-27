package com.automationexercise.testCases;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AddReviewOnProductTest_021 extends BaseClass{

    @Test
    public void addReviewOnProductTest(){

        HomePage homePage=new HomePage(driver);
        ProductsPage productsPage=new ProductsPage(driver);
        ProductDetailPage productDetailPage=new ProductDetailPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.productsBtn.click();
        Assert.assertTrue(productsPage.allProductsHeader.isDisplayed());
        ReusableMethods.waitFor(1);

        productsPage.allproducts.get(0).click();
        driver.navigate().refresh();

        Assert.assertTrue(productDetailPage.writeYourReviewHeader.isDisplayed());
        productDetailPage.nameTxtBox.sendKeys(ConfigReader.getUsername());
        productDetailPage.emailTxtBox.sendKeys(ConfigReader.getProperty("email"));
        productDetailPage.reviewTxtArea.sendKeys("review message");

        productDetailPage.submitReviewBtn.click();

        Assert.assertTrue(productDetailPage.reviewSubmittedMessage.isDisplayed());
    }
}
