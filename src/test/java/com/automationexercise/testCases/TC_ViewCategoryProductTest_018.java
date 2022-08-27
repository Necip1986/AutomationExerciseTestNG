package com.automationexercise.testCases;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.WomenCategoryPage;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class TC_ViewCategoryProductTest_018 extends BaseClass{

    @Test
    public void viewCategoryTest(){
        HomePage homePage=new HomePage(driver);
        WomenCategoryPage womenCategoryPage=new WomenCategoryPage(driver);

        Assert.assertTrue(homePage.categoryHeader.isDisplayed());
        homePage.categoryTypes.get(0).click();
        ReusableMethods.waitFor(1);

        homePage.subCategoriesOfWomen.get(0).click();
        Assert.assertTrue(womenCategoryPage.womenCategoryHeader.isDisplayed());
        womenCategoryPage.categoryTypes.get(1).click();
        ReusableMethods.waitFor(2);

        String subCategoryOfMen=womenCategoryPage.subCategoriesOfMen.get(0).getText().toLowerCase();
        womenCategoryPage.subCategoriesOfMen.get(0).click();

        System.out.println(subCategoryOfMen);

        Assert.assertTrue(driver.getTitle().toLowerCase().contains(subCategoryOfMen));
    }
}
