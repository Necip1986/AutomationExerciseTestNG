package com.automationexercise.testCases;

import com.automationexercise.pages.CustomerLandingPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginFormPage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SignUpTest_001 extends BaseClass {




    @Test(priority = 2, groups = {"smoke","E2E"})
    public void signUpTest() {

        HomePage homepage=new HomePage(driver);
        CustomerLandingPage customerHomePage=new CustomerLandingPage(driver);
        SignInPage signInPage = new SignInPage(driver);

        Assert.assertTrue(homepage.logo.isDisplayed());
        homepage.signInLink.click();
        Assert.assertTrue(signInPage.newUserSignUpHeader.isDisplayed());

        registration();

        Assert.assertTrue(customerHomePage.loggedInExpression.isDisplayed());
        customerHomePage.deleteAccountLink.click();
        Assert.assertTrue(customerHomePage.accountDeleteMessage.isDisplayed());




}
}

