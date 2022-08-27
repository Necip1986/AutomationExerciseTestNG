package com.automationexercise.testCases;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.CustomerLandingPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_VerifyAddressInCheckoutTest_023 extends BaseClass{

    @Test
    public void verifyAddressInCheckout(){
        HomePage homePage=new HomePage(driver);
        CustomerLandingPage customerLandingPage=new CustomerLandingPage(driver);
        CartPage cartPage=new CartPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.signInLink.click();
        ReusableMethods.waitFor(1);

        registration();

        Assert.assertTrue(customerLandingPage.loggedInExpression.isDisplayed());
        Actions actions=new Actions(driver);
        actions.moveToElement(homePage.hiddenPartAddToCart.get(0)).pause(2).perform();
        ReusableMethods.waitFor(3);
        homePage.addToCartOnHiddenPart.get(0).click();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitFor(1);
        homePage.continueShoppingBtn.click();
        homePage.cartLink.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(cartPage.shoppingCartExpression.isDisplayed());
        cartPage.proceedToCheckoutBtn.click();
        ReusableMethods.waitFor(1);

        Assert.assertTrue(cartPage.deliveryAddressDetail.getText().contains("new city Indiana 09876"));
        Assert.assertTrue(cartPage.invoiceAddress.getText().contains("new city Indiana 09876"));









    }
}
