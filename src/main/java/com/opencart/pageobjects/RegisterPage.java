package com.opencart.pageobjects;

import com.opencart.managers.DataFakerManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreementsToggle;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement continueButton;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password) {
        firstNameInput.sendKeys(firstName);
        System.out.println("The entered firstName is: " + firstName);

        lastNameInput.sendKeys(lastName);
        System.out.println("The entered lastName is: " + lastName);

        emailInput.sendKeys(email);
        System.out.println("The entered email is: " + email);

        passwordInput.sendKeys(password);
        System.out.println("The entered password is " + password);
    }

    public void switchONTheAggrementsToggle() {
        agreementsToggle.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }




}
