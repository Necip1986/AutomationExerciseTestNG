package com.automationexercise.testCases;

import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.testData.CommonVariable;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_ContactUsFormTest_006 extends BaseClass {

    @Test
    public void contactUcTest(){

        HomePage homePage=new HomePage(driver);
        ContactUsPage contactUs=new ContactUsPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.contactUsLink.click();

        getInTouch();

        contactUs.homeBtn.click();
        driver.navigate().refresh();
        Assert.assertTrue(homePage.logo.isDisplayed());




    }
}
