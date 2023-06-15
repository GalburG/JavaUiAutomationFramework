package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) {
// Defining a driver object that will be used for future actions.
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.apple.com/");
        String currentWindowName = driver.getWindowHandle();
        System.out.println("Current window is " + currentWindowName);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.mulberry.com/");
        driver.close();
        driver.switchTo().window(currentWindowName);
        driver.get("https://www.stiri.md/");
        driver.quit();
        System.out.println("The execution has finished");
    }
}