package com.fedytion.selenium;

import com.fedytion.gui.FilterData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumLoginService {

    public static WebDriver initDriver() {
        return new ChromeDriver();
    }

//    public static void executeWithFilters(FilterData filters) {
//        new Thread(() -> {
//            WebDriver driver = loginAndReturnDriver("email", "password");
//            if (driver != null) {
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//                MessagePageParser.applyFiltersAndSearch(driver, wait, filters);
//            }
//        }).start();
//    }

    public static boolean login(WebDriver driver, WebDriverWait wait, String email, String password) {
        try {
            driver.get("https://my.timocom.com/app/weblogin");

            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input[data-testid='email']")));
            emailInput.sendKeys(email);

            WebElement passwordInput = driver.findElement(By.cssSelector("input[data-testid='password']"));
            passwordInput.sendKeys(password);

            WebElement loginButton = driver.findElement(By.cssSelector("button[data-testid='submit-button']"));
            loginButton.click();

            wait.until(ExpectedConditions.urlContains("/app/"));
            System.out.println("Авторизація успішна!");

            return true;

        } catch (Exception e) {
            System.err.println("Помилка авторизації: " + e.getMessage());
            return false;
        }
    }
}
