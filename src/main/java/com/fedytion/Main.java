package com.fedytion;

import com.fedytion.emaillog.EmailLogService;
import com.fedytion.processor.OfferProcessor;
import com.fedytion.selenium.SeleniumLoginService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
//        EmailLogService.clearIfNeeded();
//        new OfferProcessor().processOffer();
        WebDriver driver = SeleniumLoginService.initDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        SeleniumLoginService.login(driver, wait, "Fnatalo4ka@gmail.com", "123123123");

        //EmailLogService.addEmail("someone@example.com");
    }
}
