package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFormPage {

    WebDriver localDriver;
    public LoginFormPage(WebDriver driver){
        localDriver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    public WebElement loginFormPageTitle;

    @FindBy(id = "id_gender1")
    public WebElement mrRadioBtn;

    @FindBy(id ="id_gender2")
    public WebElement mrsRadioBtn;

    @FindBy(id = "password")
    public WebElement passwordTextBox;

    @FindBy(id = "days")
    public WebElement dayDropdown;

    @FindBy(id = "months")
    public WebElement monthsDropdown;

    @FindBy(id = "years")
    public WebElement yearDropdown;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    public WebElement specialOfferCheckBox;

    @FindBy(id = "first_name")
    public WebElement firstNameTexBox;

    @FindBy(id = "last_name")
    public WebElement lastNameTexBox;

    @FindBy(id = "company")
    public WebElement companyTexBox;

    @FindBy(id = "address1")
    public WebElement address1TexBox;

    @FindBy(id = "address2")
    public WebElement address2TexBox;

    @FindBy(id = "country")
    public WebElement countryDropDown;

    @FindBy(id = "state")
    public WebElement stateTextBox;

    @FindBy(id = "city")
    public WebElement cityTextBox;

    @FindBy(id = "zipcode")
    public WebElement zipcodeTextBox;

    @FindBy(id = "mobile_number")
    public WebElement  mobileNumberTextBox;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//h2[@class=\"title text-center\"]")
    public WebElement accountCreatedMessage;

    @FindBy(xpath = "//*[@data-qa=\"continue-button\"]")
    public WebElement continueButton;
}
