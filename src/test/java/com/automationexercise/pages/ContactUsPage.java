package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    WebDriver localDriver;
    public ContactUsPage(WebDriver driver){
        localDriver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div.contact-form h2")
    public WebElement contactUsLink;

    @FindBy(name = "name")
    public WebElement nameTxtBox;

    @FindBy(name = "email")
    public WebElement emailTxtBox;

    @FindBy(name = "subject")
    public WebElement subjectTxtBox;

    @FindBy(id = "message")
    public WebElement messageTxtArea;

    @FindBy(name = "upload_file")
    public WebElement uploadFile;

    @FindBy(name = "submit")
    public WebElement submitBtn;

    @FindBy (xpath = "//div[contains(text(),'Success!')]")
    public WebElement successfullySubmittedMessage;

    @FindBy(css = "span i[class='fa fa-angle-double-left']")
    public WebElement homeBtn;


}
