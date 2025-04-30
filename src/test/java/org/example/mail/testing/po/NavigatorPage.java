package org.example.mail.testing.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatorPage extends BasePage {
    public static final By WRITE_MESSAGE_BUTTON = By.cssSelector("a[href='#compose']");
    public static final By DRAFT_FOLDER = By.cssSelector("a[href='#draft'][class='Folder-m__link--oBMDN qa-LeftColumn-FolderLink']");
    public static final By SENT_FOLDER = By.xpath("//a[@href='#sent']");
    public static final By USER_ACCOUNT = By.xpath("//button[@class=\"UserID-Account\"]");
    public static final By EXIT_ACCOUNT_BUTTON = By.xpath("//div[@class=\"MenuItem-Content\"]/span[text()=\"Выйти\"]");
    public static final By POPUP_ACCOUNT = By.xpath("//iframe[@class=\"UserWidget-Iframe\"]");
    public static final By POPUP_CONFIRM_EXIT_ACCOUNT_BUTTON = By.xpath("//a[@data-testid='logout']");


    public NavigatorPage(WebDriver driver) {
        super(driver);
    }

    public MessagePage pressWriteMessageButton() {
        webDriverWaitVisibility(60, WRITE_MESSAGE_BUTTON);
        driver.findElement(WRITE_MESSAGE_BUTTON).click();
        return new MessagePage(driver);
    }

    public MessagePage openDraftFolder() {
        driver.findElement(DRAFT_FOLDER).click();
        return new MessagePage(driver);
    }

    public BoxPage openSentFolder() {
        driver.findElement(SENT_FOLDER).click();
        return new BoxPage(driver);
    }

    public NavigatorPage openUserAccountMenu() {
        driver.findElement(USER_ACCOUNT).click();
        return this;
    }

    public NavigatorPage pressExitAccountButton() {
        webDriverWaitVisibility(POPUP_ACCOUNT);
        driver.switchTo().frame(driver.findElement(POPUP_ACCOUNT));
        driver.findElement(EXIT_ACCOUNT_BUTTON).click();
        return this;
    }

    public NavigatorPage pressConfirmExitButton() {
        webDriverWaitVisibility(POPUP_CONFIRM_EXIT_ACCOUNT_BUTTON);
        driver.findElement(POPUP_CONFIRM_EXIT_ACCOUNT_BUTTON).click();
        return this;
    }
}
