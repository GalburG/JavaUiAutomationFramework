package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
// Defining a driver object that will be used for future actions.
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.mulberry.com/");
        String currentWindowName = driver.getWindowHandle();
        System.out.println("Current window is " + currentWindowName);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");

        WebElement accountIconDropDown = driver.findElement(By.xpath("//div[@class='nav float-end']//i[@class='fa-solid fa-caret-down']"));
        accountIconDropDown.click();
        WebElement registerButton = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerButton.click();
        String firstName = DataFakerManager.getRandomFirstName();
        System.out.println("Generated First Name is " + firstName);
        String lastName = DataFakerManager.getRandomLastName();
        System.out.println("Generated LastName is " + lastName);
        String randomEmail = DataFakerManager.getRandomEmail("ggalbur+", "@gmail.com");
        System.out.println("Generated email is " + randomEmail);
        String randomPassword = DataFakerManager.getRandomPassword(8, 20);
        System.out.println("Generated password is " + randomPassword);
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(firstName);
//        Thread.sleep(2000);
        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(lastName);
//        Thread.sleep(2000);
        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys(randomEmail);
//        Thread.sleep(2000);
        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys(randomPassword);
//        Thread.sleep(2000);
        WebElement agreementsToggle = driver.findElement(By.xpath("//input[@name='agree']"));
        agreementsToggle.click();
//        Thread.sleep(2000);
        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueButton.click();
        Thread.sleep(2000);
        System.out.println("Current tab url is: " + driver.getCurrentUrl());

//        log out part
        WebElement accountIconDropDown1 = driver.findElement(By.xpath("//div[@class='nav float-end']//i[@class='fa-solid fa-caret-down']"));
        accountIconDropDown1.click();
        WebElement logOut = driver.findElement(By.cssSelector("li[class='list-inline-item'] li:nth-child(5) a:nth-child(1)"));
        logOut.click();

//        log in part
        Thread.sleep(500);
        WebElement accountIconDropDown2 = driver.findElement(By.xpath("//div[@class='nav float-end']//i[@class='fa-solid fa-caret-down']"));
        accountIconDropDown2.click();
        WebElement logIn = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
        logIn.click();
        WebElement logInEmailInput = driver.findElement(By.id("input-email"));
        logInEmailInput.sendKeys(randomEmail);
        WebElement logInPasswordInput = driver.findElement(By.id("input-password"));
        logInPasswordInput.sendKeys(randomPassword);
        WebElement logInButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        logInButton.click();

//closing the session and app part
        driver.close();
        driver.switchTo().window(currentWindowName);
        driver.get("https://www.apple.com/");
        driver.quit();
        System.out.println("The execution has finished");
    }
}