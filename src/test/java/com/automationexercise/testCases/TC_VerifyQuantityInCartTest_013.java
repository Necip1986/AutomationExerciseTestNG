package com.automationexercise.testCases;


import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_VerifyQuantityInCartTest_013 extends BaseClass {

    @Test
    public void verifyQuantityInCartTest(){
        HomePage homePage=new HomePage(driver);
        ProductDetailPage productDetailPage=new ProductDetailPage(driver);
        CartPage cartPage=new CartPage(driver);

        homePage.viewProduct.get(0).click();
        Assert.assertTrue(driver.getTitle().contains("Product Details"));
        productDetailPage.quantityBox.clear();
        productDetailPage.quantityBox.sendKeys("4");
        ReusableMethods.waitFor(1);
        productDetailPage.addToCartBtn.click();
        ReusableMethods.waitFor(1);
        productDetailPage.viewCartLink.click();
        Assert.assertEquals(cartPage.productsQuantity.get(0).getText(),"4");




    }
}
