package org.example.mail.testing.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWebDriver implements IWebDriver {

    public static WebDriver createWebDriver() {
        return new FirefoxDriver();
    }
}
