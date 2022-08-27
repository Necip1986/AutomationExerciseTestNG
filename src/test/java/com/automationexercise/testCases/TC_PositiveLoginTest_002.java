package com.automationexercise.testCases;

import com.automationexercise.pages.CustomerLandingPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.testData.DataDrivenDataProvider;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_PositiveLoginTest_002 extends BaseClass {

    @Test (priority = 1, groups = {"E2E"},dataProvider = "loginData",dataProviderClass = DataDrivenDataProvider.class)
    public void loginTest(String email,String password){

        HomePage homePage=new HomePage(driver);
        SignInPage signInPage=new SignInPage(driver);
        CustomerLandingPage customerLandingPage=new CustomerLandingPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.signInLink.click();
        Assert.assertTrue(signInPage.loginToYourAccountMessage.isDisplayed());

        Assert.assertTrue(signInPage.loginToYourAccountMessage.isDisplayed());
        signInPage.loginEmailTextBox.sendKeys(email);
        signInPage.passwordTextBox.sendKeys(password);
        ReusableMethods.waitFor(1);
        signInPage.loginButton.click();
        ReusableMethods.waitFor(2);

        driver.navigate().refresh();
        Assert.assertTrue(customerLandingPage.loggedInExpression.isDisplayed());
        customerLandingPage.deleteAccountLink.click();
        Assert.assertTrue(customerLandingPage.accountDeleteMessage.isDisplayed());

    }

}
