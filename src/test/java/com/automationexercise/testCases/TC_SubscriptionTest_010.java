package com.automationexercise.testCases;

import com.automationexercise.pages.CustomerLandingPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SubscriptionTest_010 extends BaseClass {

    @Test
    public void subscriptionTest() {
        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        Assert.assertTrue(homePage.subscriptionHeader.isDisplayed());
        homePage.subscribeEmailBox.sendKeys(ConfigReader.getProperty("email"));
        homePage.subscribeButton.click();
        Assert.assertTrue(homePage.subscriptionHeader.isDisplayed());
        Assert.assertTrue(homePage.subscribedSuccessfullyMessage.isDisplayed());

    }
}
