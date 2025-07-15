package com.fedytion.selenium;

import com.fedytion.selenium.MessagePageParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumController {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SeleniumController() {
        this.driver = SeleniumLoginService.initDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }



    public void execute(String email, String password) {
        boolean loggedIn = SeleniumLoginService.login(driver, wait, email, password);
        if (loggedIn) {
            MessagePageParser.goToMessagesAndParse(driver, wait);
        } else {
            driver.quit();
        }
    }
}
