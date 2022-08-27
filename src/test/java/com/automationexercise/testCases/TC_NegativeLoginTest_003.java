package com.automationexercise.testCases;

import com.automationexercise.pages.CustomerLandingPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NegativeLoginTest_003 extends BaseClass {

    @Test(priority = 3, groups = {"smoke"})
    public void negativeLogin(){

        HomePage homePage=new HomePage(driver);
        SignInPage signInPage=new SignInPage(driver);
        CustomerLandingPage customerlandingPage=new CustomerLandingPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.signInLink.click();
        signInPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("invalid_email"));
        signInPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password"));
        signInPage.loginButton.click();

        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
        //getPageSource will bring every element
       // System.out.println(driver.getPageSource());

    }
}
