package org.example.mail.testing.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final String URL = "https://360.yandex.ru/mail/";
    public static final String LOGIN = "login";
    public static final String PASS = "pass";

    public static final By LOGIN_BUTTON = By.id("header-login-button");
    public static final By LOGIN_FIELD = By.xpath("//input[@name='login']");
    public static final By ENTER_BUTTON = By.id("passp:sign-in");
    public static final By PASSWORD_FIELD = By.cssSelector("input[placeholder='Введите пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(URL);
        return this;
    }

    public LoginPage pressLoginButton() {
        webDriverWaitVisibility(LOGIN_BUTTON);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginPage sendLogin() {
        webDriverWaitVisibility(LOGIN_FIELD);
        driver.findElement(LOGIN_FIELD).sendKeys(LOGIN);
        return this;
    }

    public LoginPage sendPass() {
        driver.findElement(PASSWORD_FIELD).sendKeys(PASS);
        return this;
    }

    public LoginPage pressEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    public NavigatorPage goToMail() {
        driver.findElement(ENTER_BUTTON).click();
        return new NavigatorPage(driver);
    }


}
