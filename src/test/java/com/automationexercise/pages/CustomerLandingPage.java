package com.automationexercise.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLandingPage {

    WebDriver localDriver;
    public CustomerLandingPage(WebDriver driver){
        localDriver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//i[@class='fa fa-user']")
    public WebElement loggedInExpression;

    @FindBy (css = "a i[class='fa fa-trash-o']")
    public WebElement deleteAccountLink;

    @FindBy (xpath = "//h1")
    public WebElement accountDeleteMessage;

    @FindBy(css = "div i[class='fa fa-lock']")
    public WebElement logout;

    @FindBy(xpath = "//div[@class='shop-menu pull-right']//li//a[@href='/view_cart']")
    public WebElement goCartLink;
}