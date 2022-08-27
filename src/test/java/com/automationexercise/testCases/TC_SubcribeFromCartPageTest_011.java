package com.automationexercise.testCases;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SubcribeFromCartPageTest_011 extends BaseClass {

    @Test
    public void SubscriptionFromCartTest(){
        HomePage homePage = new HomePage(driver);
        CartPage cartPage=new CartPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        Actions actions=new Actions(driver);

        homePage.cartLink.click();
        actions.sendKeys(Keys.END).perform();
        Assert.assertTrue(cartPage.subscriptionHeader.isDisplayed());
        cartPage.subscribeEmailBox.sendKeys(ConfigReader.getProperty("email"));
        cartPage.subscribeButton.click();
        Assert.assertTrue(cartPage.subscriptionHeader.isDisplayed());
        Assert.assertTrue(cartPage.subscribedSuccessfullyMessage.isDisplayed());
    }
}
