package com.automation.DriverSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class DriverSetup
{

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser","url"})
    public void setUp(String browser, String url){
            if (browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.driver","E:/Java_Practice_Selenium/Selenium/src/main/java/com/automation/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            driver.get(url);
            driver.manage().window().maximize();
        }

    @AfterSuite(alwaysRun = true)
    public void quit(){
        driver.quit();
    }

}
