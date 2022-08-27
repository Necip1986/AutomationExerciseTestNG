package com.automationexercise.testCases;


import com.automationexercise.pages.*;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_PlaceOrder_RegisterWhileCheckoutTest_014 extends BaseClass {

    @Test
    public void registerWhileCheckout(){

        HomePage homepage=new HomePage(driver);
        CartPage cartPage=new CartPage(driver);
        SignInPage signInPage=new SignInPage(driver);
        LoginFormPage loginFormPage=new LoginFormPage(driver);
        CustomerLandingPage customerLandingPage=new CustomerLandingPage(driver);
        PaymentPage paymentPage=new PaymentPage(driver);

        homepage.addToCart.get(0).click();
        homepage.continueShoppingBtn.click();
        ReusableMethods.waitFor(1);
        homepage.cartLink.click();
        Assert.assertTrue(driver.getTitle().contains("Checkout"));
        cartPage.proceedToCheckoutBtn.click();
        ReusableMethods.waitFor(1);
        cartPage.register_loginLink.click();
        driver.navigate().refresh();

        registration();

        driver.navigate().refresh();
        Assert.assertTrue(customerLandingPage.loggedInExpression.isDisplayed());
        homepage.cartLink.click();
        cartPage.proceedToCheckoutBtn.click();

        Assert.assertTrue(cartPage.deliveryAddressDetail.isDisplayed()
                & cartPage.reviewYourOrderHeader.isDisplayed());

        cartPage.commentTxtArea.sendKeys("buying");
        ReusableMethods.waitFor(1);
        cartPage.placeOrderBtn.click();
        driver.navigate().refresh();

        paymentInfo();

        driver.navigate().back();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(paymentPage.orderPlacedSuccessfullyMessage.isDisplayed());
        driver.navigate().forward();
        ReusableMethods.waitFor(1);
        paymentPage.continueBtn.click();












    }

}
