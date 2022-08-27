package com.automationexercise.testCases;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AddToCartRecommendedItemsTest_022 extends BaseClass{

    @Test
    public void AddToCartFromRecommendedItems(){

        HomePage homePage=new HomePage(driver);
        CartPage cartPage=new CartPage(driver);
        Actions actions=new Actions(driver);

        actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.recommendedItemsHeader.isDisplayed());

        ReusableMethods.clickWithJS(homePage.addToCartRecommendedItems.get(0));
        homePage.viewCartLink.click();
        ReusableMethods.waitFor(2);
        System.out.println(cartPage.productsName.get(0).getText());

        Assert.assertEquals(cartPage.productsName.get(0).getText(),"Blue Top");







    }
}
