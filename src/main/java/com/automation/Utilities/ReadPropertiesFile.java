package com.automation.Utilities;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadPropertiesFile {

    public String getPropertyValue(String fileName,String key) throws IOException {
        Properties properties = new Properties();
        String value;
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/"+fileName));
        }catch (FileNotFoundException file){
            System.out.println("Failed to find property file: "+ file.getMessage());
        }catch (IOException Io){
            System.out.println("Failed to open the file: "+ Io.getMessage());
        }
        value = properties.getProperty(key);
        return value;
    }
}
