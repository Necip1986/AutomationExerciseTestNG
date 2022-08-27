package com.automationexercise.testCases;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_AddToCartTest_012 extends BaseClass{


    @Test (priority = 5,groups = {"E2E"})
    public void addToCartTest() throws InterruptedException{

        HomePage homePage=new HomePage(driver);
        ProductsPage productsPage=new ProductsPage(driver);
        CartPage cartPage=new CartPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.productsBtn.click();


        String  firstProductName=productsPage.allProductsName.get(0).getText();
        int firstProductPrice=Integer.parseInt(productsPage.productPriceList.get(0).getText().replaceAll("\\D",""));
        System.out.println(firstProductPrice);
        String secondProductName=productsPage.allProductsName.get(1).getText();
        int secondProductPrice=Integer.parseInt(productsPage.productPriceList.get(1).getText().replaceAll("\\D",""));

        Actions actions=new Actions(driver);
        actions.moveToElement(productsPage.hiddenPartAddToCart.get(0)).pause(2).perform();
        ReusableMethods.waitFor(3);
        productsPage.addToCartOnHiddenPart.get(0).click();
        ReusableMethods.waitFor(1);
        productsPage.continueShoppingBtn.click();
        actions.moveToElement(productsPage.hiddenPartAddToCart.get(1)).pause(2).perform();
        productsPage.addToCartOnHiddenPart.get(1).click();
        productsPage.viewCartLink.click();
        ReusableMethods.waitFor(1);

        String firstProductAtCart=cartPage.productsName.get(0).getText();
        int firstProductPriceAtCart=Integer.parseInt(cartPage.productPriceList.get(0).getText().replaceAll("\\D",""));
        String secondProductAtCart=cartPage.productsName.get(1).getText();
        int secondProductPriceAtCart=Integer.parseInt(cartPage.productPriceList.get(1).getText().replaceAll("\\D",""));

        Assert.assertEquals(firstProductName,firstProductAtCart);
        Assert.assertEquals(firstProductPrice,firstProductPriceAtCart);
        Assert.assertEquals(secondProductName,secondProductAtCart);
        Assert.assertEquals(secondProductPrice,secondProductPriceAtCart);



    }


}
