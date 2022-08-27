package com.automationexercise.testCases;


import com.automationexercise.pages.*;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginBeforeCheckoutTest_016 extends BaseClass {

    @Test
    public void loginBeforeCheckoutTest(){
        HomePage homePage=new HomePage(driver);
        CustomerLandingPage customerLandingPage=new CustomerLandingPage(driver);
        SignInPage signInPage=new SignInPage(driver);
        CartPage cartPage=new CartPage(driver);
        PaymentPage paymentPage=new PaymentPage(driver);


        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.signInLink.click();

        login();

        Assert.assertTrue(customerLandingPage.loggedInExpression.isDisplayed());
        homePage.addToCart.get(0).click();
        homePage.cartLink.click();
        Assert.assertTrue(cartPage.shoppingCartExpression.isDisplayed());
        cartPage.proceedToCheckoutBtn.click();
        ReusableMethods.waitFor(1);

        Assert.assertTrue(cartPage.deliveryAddressDetail.isDisplayed()
                && cartPage.reviewYourOrderHeader.isDisplayed());

        cartPage.commentTxtArea.sendKeys("login before checkout");
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
