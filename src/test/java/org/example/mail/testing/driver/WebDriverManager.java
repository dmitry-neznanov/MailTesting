package org.example.mail.testing.driver;

import org.example.mail.testing.driver.factory.ChromeWebDriver;
import org.example.mail.testing.driver.factory.FirefoxWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverManager {
    private static WebDriver instance;


    private WebDriverManager() {
    }

    public static WebDriver getWebDriverInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = startBrowser();
    }

    public static WebDriver getWebDriverInstance(WebDriver browser) {
        if (instance != null) {
            return instance;
        }
        return instance = browser;
    }

    private static WebDriver startBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public static void setChromeWebDriver() {
        instance = ChromeWebDriver.createWebDriver();
    }

    public static WebDriver setFirefoxWebDriver() {
        return FirefoxWebDriver.createWebDriver();
    }

}
