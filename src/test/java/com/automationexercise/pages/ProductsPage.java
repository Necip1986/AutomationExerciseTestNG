package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {

    WebDriver localDriver;
    public ProductsPage(WebDriver driver){
        localDriver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div.features_items h2[class='title text-center']")
    public WebElement allProductsHeader;

    @FindBy(css = "i[class='fa fa-plus-square']")
    public List<WebElement>allproducts;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    public List<WebElement>allProductsName;

    @FindBy(xpath = "//div[@class='single-products']//div[@class='productinfo text-center']//h2")
    public List<WebElement> productPriceList;

    @FindBy(id = "search_product")
    public WebElement searchBox;

    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement searchedProductHeader;

    @FindBy(xpath = "//div[@class='product-overlay']//a")
    public List<WebElement> addToCartOnHiddenPart;

    @FindBy(xpath = "//div[@class='productinfo text-center']/a/i")
    public List<WebElement>addToCart;

    @FindBy (css = "button[class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingBtn;

    @FindBy(css = "div.modal-content a")
    public WebElement viewCartLink;

    @FindBy (css = "div.product-image-wrapper")
    public List<WebElement> hiddenPartAddToCart;


    @FindBy(xpath = "//div[@id='accordian']//div[@class='panel panel-default']//i")
    public List<WebElement> categoryTypes;

    @FindBy(xpath = "//div[@id='Women']//a")
    public List<WebElement> subCategoriesOfWomen;

    @FindBy(xpath = "//div[@id='Men']//a")
    public List<WebElement> subCategoriesOfMen;

    @FindBy(xpath = "//div[@class='brands_products']//h2")
    public WebElement brandHeaderOnLeftSide;

    @FindBy(xpath = "//div[@class='brands-name']//ul//li")
    public List<WebElement> brandNameList;

    @FindBy(css = "h2[class='title text-center']")
    public WebElement brandHeaderOnCenter;








}
