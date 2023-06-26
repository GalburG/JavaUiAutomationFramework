package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fa-solid fa-user']")
    protected WebElement accountIconDropDown;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    protected WebElement registerButton;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
    protected WebElement logOutButton;


    public void navigateToRegisterPageFromHeaderMenu() {
        accountIconDropDown.click();
        System.out.println("The Account icon was clicked");
        registerButton.click();
        System.out.println("The Register Button was clicked");
    }

    public void navigateToLogOutPage (){
        accountIconDropDown.click();
        System.out.println("The Account icon was clicked");
        logOutButton.click();
        System.out.println("The user logged out");
    }

}
