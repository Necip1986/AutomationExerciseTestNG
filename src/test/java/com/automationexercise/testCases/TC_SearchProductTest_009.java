package com.automationexercise.testCases;


import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SearchProductTest_009 extends BaseClass {

    @Test (priority = 4,groups = {"E2E"})
    public void searchProductTest(){
        HomePage homePage=new HomePage(driver);
        ProductsPage productsPage=new ProductsPage(driver);
        ProductDetailPage productDetailPage=new ProductDetailPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.productsBtn.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPage.allProductsHeader.isDisplayed());

        productsPage.searchBox.sendKeys("blue");
        productsPage.searchButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPage.searchedProductHeader.isDisplayed());

        int count=0;
        for(int i=0; i<productsPage.allProductsName.size();i++){
            if(productsPage.allProductsName.get(i).getText().toLowerCase().contains("blue")){

            }else{
                count++;
            }
        }
        System.out.println(count);
        Assert.assertTrue(count==0);

    }
}
