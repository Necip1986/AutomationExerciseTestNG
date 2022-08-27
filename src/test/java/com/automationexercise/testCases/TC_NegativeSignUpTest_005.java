package com.automationexercise.testCases;

import com.automationexercise.pages.CustomerLandingPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginFormPage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NegativeSignUpTest_005 extends BaseClass {

    @Test
    public void signUpWithUsedEmail(){
        HomePage homepage=new HomePage(driver);
        LoginFormPage loginFormPage =new LoginFormPage(driver);
        SignInPage signInPage=new SignInPage(driver);
        CustomerLandingPage customerHomePage=new CustomerLandingPage(driver);

        Assert.assertTrue(homepage.logo.isDisplayed());
        homepage.signInLink.click();
        Assert.assertTrue(homepage.newUserSignUpHeader.isDisplayed());
        homepage.nameBox.sendKeys(ConfigReader.getProperty("name"));
        homepage.signUpEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
        homepage.signUpButton.click();
        Assert.assertTrue(signInPage.emailUsedError.isDisplayed());
    }
}
