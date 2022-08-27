package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenCategoryPage extends ProductsPage{

    WebDriver localDriver;

    public WomenCategoryPage(WebDriver remoteDriver){
        super(remoteDriver);
        localDriver=remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(xpath = "//h2[text()='Women - Dress Products']")
    public WebElement womenCategoryHeader;
}
