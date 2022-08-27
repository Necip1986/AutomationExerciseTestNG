package com.automationexercise.pages;

import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    WebDriver localDriver;

    public CartPage(WebDriver remoteDriver){
        localDriver=remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(xpath = "//footer[@id='footer']//h2")
    public WebElement subscriptionHeader;

    @FindBy (id = "susbscribe_email")
    public WebElement subscribeEmailBox;

    @FindBy(id = "subscribe")
    public WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement subscribedSuccessfullyMessage;

    @FindBy(css = "tbody tr td h4 a")
    public List<WebElement>productsName;

    @FindBy(css = "tbody tr td[class='cart_price']")
    public List<WebElement>productPriceList;

    @FindBy(css = "tbody tr td[class='cart_quantity']")
    public List<WebElement>productsQuantity;

    @FindBy(css = "a[class='btn btn-default check_out'")
    public WebElement proceedToCheckoutBtn;

    @FindBy(css = "div.modal-content u")
    public WebElement register_loginLink;

    @FindBy(css = "ul#address_delivery")
    public WebElement deliveryAddressDetail;

    @FindBy(xpath = "//h2[contains(text(),'Review Your Order')]")
    public WebElement reviewYourOrderHeader;

    @FindBy(css = "textarea.form-control")
    public WebElement commentTxtArea;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement placeOrderBtn;

    @FindBy (css = "li.active")
    public WebElement shoppingCartExpression;

    @FindBy (css = "i[class='fa fa-times']")
    public WebElement removeBtn;

    @FindBy(id = "empty_cart")
    public WebElement cartEmptyExpression;

    @FindBy(xpath = "//ul[@id='address_invoice']")
    public WebElement invoiceAddress;










}
