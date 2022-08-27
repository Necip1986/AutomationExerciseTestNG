package com.automationexercise.testData;

import org.testng.annotations.DataProvider;

public class DataDrivenDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){
        Object[][] data={{"mehmet762946@gmail.com","ahmet"},
                        {"mehmet1234@gmail.com","ahmet"},
                        {"adnan1234@gmail.com","adnan"}};

        return data;


    }
}
