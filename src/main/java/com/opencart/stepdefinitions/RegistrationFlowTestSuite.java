package com.opencart.stepdefinitions;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;

public class RegistrationFlowTestSuite {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    static int counter = 0;

    @BeforeEach
    public void executeTheCodeBeforeEachTestFromThisClass(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        counter++;
        System.out.println("The test scenario nr " + counter + " has started ");
    }

    @Test
    @DisplayName("Customer creation_ Successfull scenario.")
    public void registerFlowRedirecstUserToTheCorrectUrl() throws InterruptedException {
        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomFirstName();
        String lastName = DataFakerManager.getRandomLastName();
        String email = DataFakerManager.getRandomEmail("ggalbur+", "@gmail.com");
        String password = DataFakerManager.getRandomPassword(8, 21);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        registerPage.switchONTheAgreementsToggle();
        registerPage.clickOnContinueButton();
        Thread.sleep(1000);

        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheExpectedKeyWord = driver.getCurrentUrl().contains("https://andreisecuqa.host/index.php?route=account/success");
        Assertions.assertTrue(urlContainsTheExpectedKeyWord, "The account creation page URL contains success key word");
    }


    @Test
    @DisplayName("Customer creation Fails due to Agreements Toggle not being checked ON_rainy scenario.")
    public void registerFlowUnsuccessfullDueToAgreementsToggle() throws InterruptedException {
        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomFirstName();
        String lastName = DataFakerManager.getRandomLastName();
        String email = DataFakerManager.getRandomEmail("ggalbur+", "@gmail.com");
        String password = DataFakerManager.getRandomPassword(8, 21);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
//        For this scenario pls keep disabled the Toggle
//        registerPage.switchONTheAgreementsToggle();
        registerPage.clickOnContinueButton();
        registerPage.clickOnCloseAlert();
        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheExpectedKeyWord = driver.getCurrentUrl().contains("https://andreisecuqa.host/index.php?route=account/success");
        Assertions.assertFalse(urlContainsTheExpectedKeyWord, "The account creation page URL does not contains success key word");
    }

    @AfterEach
    public void executeThisMethodAfterEachTest() {
        DriverManager.getInstance().quiTheDriver();
        System.out.println("The test scenario nr " + counter + " has finished ");
    }

}
