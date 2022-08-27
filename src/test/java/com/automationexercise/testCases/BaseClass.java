package com.automationexercise.testCases;

import com.automationexercise.pages.*;
import com.automationexercise.testData.CommonVariable;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public static WebDriver driver;


    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String browser){

        //driver=null;
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    //ChromeOptions options = new ChromeOptions();
                    //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\browser\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());



    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        if (driver != null) {//if the driver is pointing chrome
            driver.quit();//quit the driver
            driver = null;//set it back to null to make sure driver is null
            // so I can initialize it again
            //This is important especially you do cross browser testing(testing with
            // multiple browser like chrome, firefox, ie etc.)
        }
    }

    public void login(){
        SignInPage signInPage=new SignInPage(driver);
        Assert.assertTrue(signInPage.loginToYourAccountMessage.isDisplayed());
        signInPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
        signInPage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.waitFor(1);
        signInPage.loginButton.click();
        ReusableMethods.waitFor(2);


    }

    public void paymentInfo(){
        PaymentPage paymentPage=new PaymentPage(driver);
        Actions actions=new Actions(driver);

        driver.navigate().refresh();
        actions.doubleClick(paymentPage.nameOnCardTxtBox).perform();
        paymentPage.nameOnCardTxtBox.sendKeys("Yunus");
        paymentPage.cardNumberTxtBox.sendKeys("1234562345667");
        paymentPage.cvcTxtBox.sendKeys("511");
        paymentPage.expirationMonthTxtBox.sendKeys("January");
        paymentPage.expiryYearTxtBox.sendKeys("2000");
        paymentPage.pay_confirmBtn.click();

    }

    public void registration(){
        SignInPage signInPage = new SignInPage(driver);
        LoginFormPage loginFormPage=new LoginFormPage(driver);
        HomePage homepage=new HomePage(driver);
        Actions actions=new Actions(driver);

        Faker faker=new Faker();

        homepage.nameBox.sendKeys(faker.name().firstName());
        homepage.signUpEmailTextBox.sendKeys(faker.internet().emailAddress());
        homepage.signUpButton.click();
        ReusableMethods.waitFor(1);
        driver.navigate().refresh();
        //Login form
        actions.doubleClick(loginFormPage.mrRadioBtn).perform();

        //apache commons.lan3 librarisinden geliyor
        loginFormPage.passwordTextBox.sendKeys(RandomStringUtils.randomAlphabetic(5));

        Select selectDay=new Select(loginFormPage.dayDropdown);
        selectDay.selectByValue("1");
        Select selectMonth=new Select(loginFormPage.monthsDropdown);
        selectMonth.selectByVisibleText("January");
        Select selectYear=new Select(loginFormPage.yearDropdown);
        selectYear.selectByValue("2000");
        ReusableMethods.waitFor(1);

        ReusableMethods.clickWithJS(loginFormPage.newsletterCheckBox);
        loginFormPage.specialOfferCheckBox.click();

        loginFormPage.firstNameTexBox.sendKeys("ahmet");
        loginFormPage.lastNameTexBox.sendKeys("kaya");
        loginFormPage.companyTexBox.sendKeys("automation exercise");
        loginFormPage.address1TexBox.sendKeys("UK");
        loginFormPage.address2TexBox.sendKeys("Ashington");
        Select selectCountry=new Select(loginFormPage.countryDropDown);
        selectCountry.selectByVisibleText("United States");
        loginFormPage.stateTextBox.sendKeys("Indiana");
        loginFormPage.cityTextBox.sendKeys("new city");

        //apache commons.lan3 librarisinden geliyor
        loginFormPage.zipcodeTextBox.sendKeys(RandomStringUtils.randomNumeric(6));
        loginFormPage.mobileNumberTextBox.sendKeys("234556");
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(loginFormPage.createAccountButton);
        Assert.assertTrue(loginFormPage.accountCreatedMessage.isDisplayed());
        loginFormPage.continueButton.click();
        ReusableMethods.waitFor(1);
        driver.navigate().refresh();
    }

    public void goToCart(){
        CustomerLandingPage customerLandingPage=new CustomerLandingPage(driver);
        customerLandingPage.goCartLink.click();
    }

    public void getInTouch(){
        ContactUsPage contactUs=new ContactUsPage(driver);
        contactUs.nameTxtBox.sendKeys(ConfigReader.getProperty("name"));
        contactUs.emailTxtBox.sendKeys(ConfigReader.getProperty("email"));
        contactUs.subjectTxtBox.sendKeys("request");
        contactUs.messageTxtArea.sendKeys("Hi");
        contactUs.uploadFile.sendKeys(CommonVariable.filePath);
        ReusableMethods.waitFor(2);
        contactUs.submitBtn.click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(contactUs.successfullySubmittedMessage.isDisplayed());
    }
}
