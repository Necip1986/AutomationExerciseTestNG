package com.automationexercise.testCases;

import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_ScroolUpDownFunctionWithoutArrowTest_026 extends BaseClass{

    @Test
    public void scrollUpDownWithoutArrow(){

        Actions actions=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        HomePage homePage=new HomePage(driver);

        ReusableMethods.scrollToElement(homePage.subscriptionHeader);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.subscriptionHeader.isDisplayed());


        ReusableMethods.scrollToElement(homePage.fullFledgedExpression.get(0));
        ReusableMethods.waitFor(2);
        wait.until(ExpectedConditions.visibilityOf(homePage.fullFledgedExpression.get(0)));
        Assert.assertTrue(homePage.fullFledgedExpression.get(0).isDisplayed());

    }
}
