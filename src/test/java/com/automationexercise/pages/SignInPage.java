package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    WebDriver localDriver;
    public SignInPage(WebDriver driver){
        localDriver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "div[class='signup-form'] h2")
    public WebElement newUserSignUpHeader;

    @FindBy(name = "name")
    public WebElement nameBox;

    @FindBy(css = "div[class='signup-form'] input[name='email']")
    public WebElement signUpEmailTextBox;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(css = "div.login-form h2")
    public WebElement loginToYourAccountMessage;

    @FindBy (xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmailTextBox;

    @FindBy(name = "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[contains(text(),'incorrect!')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//p[contains(text(),'exist!')]")
    public WebElement emailUsedError;


}













