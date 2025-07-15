package com.fedytion.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessagePageParser {

    public static void goToMessagesAndParse(WebDriver driver, WebDriverWait wait) {
        try {
            driver.get("https://my.timocom.com/app/messages");

            WebElement messageBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".message-item")));
            System.out.println("📨 Перше повідомлення: " + messageBlock.getText());

        } catch (Exception e) {
            System.err.println("❌ Не вдалося завантажити повідомлення: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
