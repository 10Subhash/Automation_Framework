package com.automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.DriverSetup.DriverSetup.driver;

public class Login
{
    //todo : Locators


    @FindBy(xpath = "//div//input[@id=\"username\"]")
    public WebElement user;

    @FindBy(xpath = "//div//input[@id=\"password\"]")
    public WebElement pass;

    @FindBy(xpath = "//div//button[@id=\"submit\"]")
    public WebElement submit;

    @FindBy(xpath = "//a[text()=\"Log out\"]")
    public WebElement logout;

    @FindBy(xpath = "//*[text()=\"Congratulations student. You successfully logged in!\"]")
    public WebElement header;

    public Login(){
        PageFactory.initElements(driver,this);
    }

    public void addUser(String setUser){
        user.sendKeys(setUser);
    }

    public void addPass(String setPass){
        pass.sendKeys(setPass);
    }

    public void clickSubmitButton(){
        submit.click();
    }

    public String verifyHeader(){
      return header.getText();
    }

    public void clickLogoutButton(){
        logout.click();
    }
}
