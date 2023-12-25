package utility;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;


public class Property {

    private Properties properties;
    private final String testDataFilePath = "configs//testdata.properties";

    public Property() {
        File ConfigFile = new File(testDataFilePath);
        try {
            FileInputStream configFileReader = new FileInputStream(ConfigFile);
            properties = new Properties();
            try {
                properties.load(configFileReader);
                configFileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("testdata.properties not found at config file path " + testDataFilePath);
        }
    }
    public String getApplicationUrl() {
        String applicationurl= properties.getProperty("websiteURL");
        if(applicationurl != null)
            return applicationurl;
        else
            throw new RuntimeException("Application url not specified in the config.properties file.");

    }
}
