package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

    WebDriver localDriver;
    public TestCasesPage(WebDriver driver){
        localDriver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement testCasesHeader;

}
