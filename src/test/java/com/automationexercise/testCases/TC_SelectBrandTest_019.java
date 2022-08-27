package com.automationexercise.testCases;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectBrandTest_019 extends BaseClass{

    @Test
    public void brandFunctionTest(){
        HomePage homePage=new HomePage(driver);
        ProductsPage productsPage=new ProductsPage(driver);

        homePage.productsBtn.click();
        Assert.assertTrue(productsPage.brandHeaderOnLeftSide.isDisplayed());

        String brandName1=productsPage.brandNameList.get(0).getText().toLowerCase().replaceAll("[^a-zA-Z]","");
        System.out.println(brandName1.replaceAll("[^a-zA-Z]",""));
        productsPage.brandNameList.get(0).click();
        System.out.println(productsPage.brandHeaderOnCenter.getText().toLowerCase());
        Assert.assertTrue(productsPage.brandHeaderOnCenter.getText().toLowerCase().contains(brandName1));

        String brandName2=productsPage.brandNameList.get(2).getText().toLowerCase().replaceAll("[^a-zA-Z]","");
        productsPage.brandNameList.get(2).click();
        Assert.assertTrue(productsPage.brandHeaderOnCenter.getText().toLowerCase().contains(brandName2));


    }
}
