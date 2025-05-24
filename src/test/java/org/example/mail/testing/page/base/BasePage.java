package org.example.mail.testing.page.base;

import org.example.mail.testing.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private static final int SECONDS = 10;

    public BasePage() {
        this.driver = WebDriverManager.getWebDriverInstance();
    }

    protected void webDriverWaitVisibility(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(SECONDS)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void webDriverWaitVisibility(int duration, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(duration)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
