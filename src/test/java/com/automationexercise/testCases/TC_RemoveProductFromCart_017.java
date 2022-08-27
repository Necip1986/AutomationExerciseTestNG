package com.automationexercise.testCases;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RemoveProductFromCart_017 extends BaseClass{

    @Test
    public void removeProductFromCartTest() {

        HomePage homePage=new HomePage(driver);
        CartPage cartPage=new CartPage(driver);

        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.addToCart.get(4).click();
        homePage.continueShoppingBtn.click();
        homePage.cartLink.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(cartPage.shoppingCartExpression.isDisplayed());
        cartPage.removeBtn.click();

        ReusableMethods.waitFor(2);
        Assert.assertTrue(cartPage.cartEmptyExpression.isDisplayed());

    }

}
