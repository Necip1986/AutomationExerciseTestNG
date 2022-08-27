package com.automationexercise.testCases;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_TestCasesPageTest_007 extends BaseClass {

    @Test
    public void testCasePageTest(){
        HomePage homePage=new HomePage(driver);
        TestCasesPage tcPage=new TestCasesPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.testCasesButton.click();
        Assert.assertTrue(tcPage.testCasesHeader.isDisplayed());
    }
}
