package com.automationexercise.testCases;

import com.automationexercise.pages.LoginPage;
import com.automationexercise.utilities.ConfigReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DenemeGuruBank extends BaseClass {

    LoginPage lp=new LoginPage(driver);
    Logger logger = (Logger) LogManager.getLogger(DenemeGuruBank.class);


    public void loginTest() throws InterruptedException {
        LoginPage lp=new LoginPage(driver);
        logger.info("URL is open");
        Thread.sleep(3000);
        lp.setUserName(ConfigReader.getUsername());
        logger.info("entered username");
        lp.setPassword(ConfigReader.getPassword());
        logger.info("entered password");
        lp.clickBtnLogin();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("login test passed");
        }else{
            Assert.assertTrue(false);
            logger.info("login test failed");
        }


    }
}
