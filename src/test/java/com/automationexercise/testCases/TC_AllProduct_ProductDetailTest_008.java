package com.automationexercise.testCases;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AllProduct_ProductDetailTest_008 extends BaseClass{

    @Test
    public void productTest(){
        HomePage homePage=new HomePage(driver);
        ProductsPage productsPage=new ProductsPage(driver);
        ProductDetailPage productDetailPage=new ProductDetailPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.productsBtn.click();
        Assert.assertTrue(productsPage.allProductsHeader.isDisplayed());

        productsPage.allproducts.get(0).click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(productDetailPage.productName.isDisplayed()&
                productDetailPage.productCategoryInfo.isDisplayed()&
                productDetailPage.productPriceInfo.isDisplayed()&
                productDetailPage.productAvailabilityInfo.isDisplayed()&
                productDetailPage.productConditionInfo.isDisplayed()&
                productDetailPage.productBrandName.isDisplayed());
    }

}
