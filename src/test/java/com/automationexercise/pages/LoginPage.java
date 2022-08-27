package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver localDriver;

    public LoginPage(WebDriver remoteDriver){
        localDriver=remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(name = "uid")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(name = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(css = "button#save span span")
    @CacheLookup
    public WebElement captcha;

    public void setUserName(String userName) {
        txtUserName.sendKeys(userName);
    }

    public void setPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

}
