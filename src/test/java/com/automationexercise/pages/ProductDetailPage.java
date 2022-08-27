package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.PortUnreachableException;

public class ProductDetailPage {

    WebDriver localDriver;
    public ProductDetailPage(WebDriver driver){
        localDriver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div.product-information span span")
    public WebElement productPriceInfo;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(text(),'Category')]")
    public WebElement productCategoryInfo;

    @FindBy(css = "div.product-information h2")
    public WebElement productName;

    @FindBy (xpath = "//div[@class='product-information']/p/b[text()='Availability:']")
    public WebElement productAvailabilityInfo;

    @FindBy(xpath = "//div[@class='product-information']/p/b[text()='Condition:']")
    public WebElement productConditionInfo;

    @FindBy(xpath = "//div[@class='product-information']/p/b[text()='Brand:']")
    public WebElement productBrandName;

    @FindBy(xpath = "//title[contains(text(),'Product Details')]")
    public WebElement productDetailsPageTitle;

    @FindBy(id = "quantity")
    public WebElement quantityBox;

    @FindBy(css = "button i[class='fa fa-shopping-cart']")
    public WebElement addToCartBtn;

    @FindBy (css = "div.modal-content u")
    public WebElement viewCartLink;

    @FindBy(id = "name")
    public WebElement nameTxtBox;

    @FindBy(id = "email")
    public WebElement emailTxtBox;

    @FindBy(id = "review")
    public WebElement reviewTxtArea;

    @FindBy(id = "button-review")
    public WebElement submitReviewBtn;

    @FindBy(xpath = "//*[contains(text(),'Thank you for your review.')]")
    public WebElement reviewSubmittedMessage;

    @FindBy(css = "a[data-toggle='tab']")
    public WebElement writeYourReviewHeader;









}
