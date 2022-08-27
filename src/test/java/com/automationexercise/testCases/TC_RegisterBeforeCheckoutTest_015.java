package com.automationexercise.testCases;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.PaymentPage;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RegisterBeforeCheckoutTest_015 extends BaseClass{

    @Test
    public void registerBeforeCheckoutTest(){
        HomePage homePage=new HomePage(driver);
        CartPage cartPage=new CartPage(driver);
        PaymentPage paymentPage=new PaymentPage(driver);

        homePage.signInLink.click();
        registration();
        driver.navigate().refresh();

        homePage.addToCart.get(0).click();
        homePage.continueShoppingBtn.click();
        homePage.cartLink.click();
        Assert.assertTrue(cartPage.shoppingCartExpression.isDisplayed());
        cartPage.proceedToCheckoutBtn.click();

        Assert.assertTrue(cartPage.deliveryAddressDetail.isDisplayed()
                &cartPage.reviewYourOrderHeader.isDisplayed());

        cartPage.commentTxtArea.sendKeys("registered before checkout");
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
