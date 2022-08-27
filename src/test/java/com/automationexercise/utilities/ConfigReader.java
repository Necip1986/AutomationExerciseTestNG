package com.automationexercise.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    static {
        String path = "./Configuration/configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }


    //second way
    public static String getUsername(){
        String username=properties.getProperty("username");
        return username;
    }

    public static String getPassword(){
        String password=properties.getProperty("password");
        return password;
    }

    public static String getUrl(){
        String url=properties.getProperty("baseURL");
        return url;
    }



}
