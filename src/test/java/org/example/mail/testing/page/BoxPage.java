package org.example.mail.testing.page;

import org.example.mail.testing.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoxPage extends BasePage {
    public static final By DRAFT_MESSAGE = By.xpath("//div[@class=\"mail-MessageSnippet-Wrapper\"]");
    public static final By SENT_MESSAGE = By.xpath("//div[@class=\"ns-view-container-desc mail-MessagesList js-messages-list\"]");

    public WebElement getDraftMessageInFolder() {
        webDriverWaitVisibility(DRAFT_MESSAGE);
        return driver.findElement(DRAFT_MESSAGE);
    }

    public MessagePage openDraftMessage() {
        webDriverWaitVisibility(DRAFT_MESSAGE);
        driver.findElement(DRAFT_MESSAGE).click();
        return new MessagePage();
    }

    public Boolean isDraftMessageSent() {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(DRAFT_MESSAGE));
    }

    public WebElement getSentMessageInFolder() {
        webDriverWaitVisibility(15, SENT_MESSAGE);
        return driver.findElement(SENT_MESSAGE);
    }
}
