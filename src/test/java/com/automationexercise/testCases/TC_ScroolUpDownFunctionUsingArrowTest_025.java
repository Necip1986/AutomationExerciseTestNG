package com.automationexercise.testCases;

import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class TC_ScroolUpDownFunctionUsingArrowTest_025 extends BaseClass{

    @Test
    public void scrollUpDownUsingArrow(){
        Actions actions=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        HomePage homePage=new HomePage(driver);

        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.subscriptionHeader.isDisplayed());

        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.PAGE_UP).sendKeys(Keys.UP).perform();
        ReusableMethods.waitFor(2);
        wait.until(ExpectedConditions.visibilityOf(homePage.fullFledgedExpression.get(0)));
        Assert.assertTrue(homePage.fullFledgedExpression.get(0).isDisplayed());



    }
}
