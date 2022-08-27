package com.automationexercise.testCases;

import com.automationexercise.pages.CustomerLandingPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LogoutTest_004 extends BaseClass{

    @Test
    public void logoutTest(){

        HomePage homePage=new HomePage(driver);
        SignInPage signInPage=new SignInPage(driver);
        CustomerLandingPage customerLandingPage=new CustomerLandingPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.signInLink.click();
        login();

        ReusableMethods.waitFor(2);
        Assert.assertTrue(customerLandingPage.loggedInExpression.isDisplayed());
        customerLandingPage.logout.click();
        Assert.assertTrue(signInPage.loginToYourAccountMessage.isDisplayed());

    }
}
