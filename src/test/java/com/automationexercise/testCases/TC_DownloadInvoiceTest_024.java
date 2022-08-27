package com.automationexercise.testCases;

import com.automationexercise.pages.*;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_DownloadInvoiceTest_024 extends BaseClass {

    @Test
    public void downloadInvoiceTest(){
        HomePage homepage=new HomePage(driver);
        CartPage cartPage=new CartPage(driver);
        CustomerLandingPage customerLandingPage=new CustomerLandingPage(driver);
        PaymentPage paymentPage=new PaymentPage(driver);
        Actions actions=new Actions(driver);

        homepage.addToCart.get(0).click();
        homepage.continueShoppingBtn.click();
        ReusableMethods.waitFor(1);
        homepage.cartLink.click();
        Assert.assertTrue(driver.getTitle().contains("Checkout"));
        cartPage.proceedToCheckoutBtn.click();
        ReusableMethods.waitFor(1);
        cartPage.register_loginLink.click();
        ReusableMethods.waitFor(1);

        driver.navigate().refresh();

        registration();

        Assert.assertTrue(customerLandingPage.loggedInExpression.isDisplayed());
        actions.doubleClick(homepage.cartLink).perform();
        cartPage.proceedToCheckoutBtn.click();

        driver.navigate().refresh();

        Assert.assertTrue(cartPage.deliveryAddressDetail.isDisplayed()
                & cartPage.reviewYourOrderHeader.isDisplayed());

        cartPage.commentTxtArea.sendKeys("buying");
        ReusableMethods.waitFor(1);
        cartPage.placeOrderBtn.click();

        paymentInfo();

        Assert.assertTrue(paymentPage.orderPlacedSuccessfullyMessage.isDisplayed());
        ReusableMethods.waitFor(1);

        //org.openqa.selenium.json.JsonException: java.lang.reflect.InvocationTargetException
        Assert.assertTrue(paymentPage.downloadInvoiceBtn.isDisplayed());
        ReusableMethods.doubleClick(paymentPage.downloadInvoiceBtn);
        ReusableMethods.waitFor(5);


    }
}
