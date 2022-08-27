package com.automationexercise.testCases;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TC_VerifyCartAfterLogin_020 extends BaseClass{

    @Test(priority = 6,groups = {"E2E"})
    public void verifyCartAfterLogin(){
        HomePage homePage=new HomePage(driver);
        ProductsPage productsPage=new ProductsPage(driver);
        CartPage cartPage=new CartPage(driver);
        Actions actions=new Actions(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.productsBtn.click();
        Assert.assertTrue(productsPage.allProductsHeader.isDisplayed());

        productsPage.searchBox.sendKeys("jeans");
        productsPage.searchButton.click();

        int count=0;
        for(int i=0; i<productsPage.allProductsName.size();i++){
            if(productsPage.allProductsName.get(i).getText().toLowerCase().contains("jeans")){

            }else{
                count++;
            }
        }
        Assert.assertTrue(count==0);

        List<String> productNames=new ArrayList<>();
        for(int i=0; i<productsPage.allProductsName.size();i++){
            productNames.add(productsPage.allProductsName.get(i).getText());
            productsPage.addToCart.get(i).click();
            ReusableMethods.waitFor(1);
            productsPage.continueShoppingBtn.click();
        }

        System.out.println("actual names "+productNames);
        actions.doubleClick(homePage.cartLink).perform();

        List<String > addedProductNamesBeforeSignIn=new ArrayList<>();
        for(int i=0; i<cartPage.productsName.size();i++){
            addedProductNamesBeforeSignIn.add(cartPage.productsName.get(i).getText());
        }
        System.out.println("before signin "+addedProductNamesBeforeSignIn);

        Assert.assertEquals(addedProductNamesBeforeSignIn,productNames);

        actions.doubleClick(homePage.signInLink).perform();
        login();
        driver.navigate().refresh();

        goToCart();

        List<String > addedProductNamesAfterSignIn=new ArrayList<>();
        for(int i=0; i<cartPage.productsName.size();i++){
            addedProductNamesAfterSignIn.add(cartPage.productsName.get(i).getText());
        }

        System.out.println("after signin "+addedProductNamesAfterSignIn);


        Assert.assertEquals(productNames,addedProductNamesAfterSignIn);


    }
}
