package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;


public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();

//        for (int i = 0; i < 5; i++) {

            driver.get("https://andreisecuqa.host/");

            HomePage homePage = new HomePage(driver);
            homePage.navigateToRegisterPageFromHeaderMenu();

            String firstName = DataFakerManager.getRandomFirstName();
            String lastName = DataFakerManager.getRandomLastName();
            String email = DataFakerManager.getRandomEmail("ggalbur+", "@gmail.com");
            String password = DataFakerManager.getRandomPassword(8, 21);

            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
            registerPage.switchONTheAgreementsToggle();
            registerPage.clickOnContinueButton();
            Thread.sleep(2000);

            System.out.println(driver.getCurrentUrl());
            homePage.navigateToLogOutPage();

//        driver.quit();
            System.out.println("The execution has finished");

//        }
    }
}