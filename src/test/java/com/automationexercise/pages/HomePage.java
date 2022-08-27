package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver localDriver;
    public HomePage(WebDriver driver){
        localDriver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class=\"logo pull-left\"]")
    public WebElement logo;

    @FindBy(css = "a i[class='fa fa-lock']")
    public WebElement signInLink;

    @FindBy(css = "div[class='signup-form'] h2")
    public WebElement newUserSignUpHeader;

    @FindBy(name = "name")
    public WebElement nameBox;

    @FindBy(css = "div[class='signup-form'] input[name='email']")
    public WebElement signUpEmailTextBox;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(css = "div i[class='fa fa-envelope']")
    public WebElement contactUsLink;

    @FindBy(xpath = "//button[@class='btn btn-success' and text()='Test Cases']")
    public WebElement testCasesButton;

    @FindBy(css = "i[class='material-icons card_travel']")
    public WebElement productsBtn;

    @FindBy(xpath = "//footer[@id='footer']//h2")
    public WebElement subscriptionHeader;

    @FindBy (id = "susbscribe_email")
    public WebElement subscribeEmailBox;

    @FindBy(id = "subscribe")
    public WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement subscribedSuccessfullyMessage;

    @FindBy(xpath = "//div[@class='shop-menu pull-right']//li//a[@href='/view_cart']")
    public WebElement cartLink;

    @FindBy(css = "i[class='fa fa-plus-square']")
    public List<WebElement> viewProduct;

    @FindBy(xpath = "//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']")
    public List<WebElement>addToCart;

    @FindBy (css = "button[class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingBtn;

    @FindBy(xpath = "//div[@class='left-sidebar']/h2")
    public WebElement categoryHeader;

    @FindBy(xpath = "//div[@id='accordian']//div[@class='panel panel-default']//i")
    public List<WebElement> categoryTypes;

    @FindBy(xpath = "//div[@id='Women']//a")
    public List<WebElement> subCategoriesOfWomen;

    @FindBy(xpath = "//h2[text()='Women - Dress Products']")
    public WebElement womenCategoryTitle;

    @FindBy(xpath = "//div[@class='recommended_items']/h2")
    public WebElement recommendedItemsHeader;

    @FindBy(xpath = "//div[@class='recommended_items']//a//i[@class='fa fa-shopping-cart']")
    public List<WebElement> addToCartRecommendedItems;

    @FindBy(xpath = "//div[@id='recommended-item-carousel']//div[@class='productinfo text-center']")
    public List<WebElement> recommendedItemName;

    @FindBy(css = "div.modal-content a")
    public WebElement viewCartLink;

    @FindBy (css = "div.product-image-wrapper")
    public List<WebElement> hiddenPartAddToCart;

    @FindBy(xpath = "//div[@class='product-overlay']//a")
    public List<WebElement> addToCartOnHiddenPart;

    @FindBy(xpath = "//h2[contains(text(),'Full-Fledged')]")
    public List<WebElement> fullFledgedExpression;

















}

