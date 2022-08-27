package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver localDriver;

    public PaymentPage(WebDriver remoteDriver){
        localDriver=remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(name = "name_on_card")
    public WebElement nameOnCardTxtBox;

    @FindBy(name = "card_number")
    public WebElement cardNumberTxtBox;

    @FindBy(name = "cvc")
    public WebElement cvcTxtBox;

    @FindBy(name = "expiry_month")
    public WebElement expirationMonthTxtBox;

    @FindBy(name = "expiry_year")
    public WebElement expiryYearTxtBox;

    @FindBy(id = "submit")
    public WebElement pay_confirmBtn;

    @FindBy(css = "div#success_message div[class='alert-success alert'")
    public WebElement orderPlacedSuccessfullyMes;

    @FindBy(css = "a[data-qa='continue-button']")
    public WebElement continueBtn;

    @FindBy(xpath = "//div[@id='success_message']//div[@class='alert-success alert']")
    public WebElement orderPlacedSuccessfullyMessage;

    @FindBy (xpath = "//a[text()='Download Invoice']")
    public WebElement downloadInvoiceBtn;




}
