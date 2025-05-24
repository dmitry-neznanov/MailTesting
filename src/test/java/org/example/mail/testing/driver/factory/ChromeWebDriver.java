package org.example.mail.testing.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver implements IWebDriver {

    public static WebDriver createWebDriver() {
        return new ChromeDriver();
    }
}
