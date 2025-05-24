package org.example.mail.testing.page;

import org.openqa.selenium.By;

public class MessagePage extends BoxPage {
    public static final By ADDRESS_FIELD = By.cssSelector("div[id='compose-field-1']");
    public static final By POPUP_ADDRESS = By.id(":a11y-compose-listbox");
    public static final By SUBJECT_FIELD = By.id("compose-field-subject-4");
    public static final By TEXT_FIELD = By.xpath("//div[contains(@class, 'cke_wysiwyg_div') and @contenteditable='true']");
    public static final By ADDRESS_CONTENT = By.cssSelector("span[data-email='dimakraskin@yandex.ru']");
    public static final By SUBJECT_CONTENT = By.xpath("//input[@class='composeTextField ComposeSubject-TextField']");
    public static final By SEND_BUTTON = By.cssSelector("button[class='Button2 Button2_view_action Button2_size_l']");
    public static final By TEXT_FIELD_CONTENT = By.xpath("//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']");

    public MessagePage fillAddress() {
        driver.findElement(ADDRESS_FIELD).click();
        return this;
    }

    public MessagePage choseAddress() {
        driver.findElement(POPUP_ADDRESS).click();
        return this;
    }

    public MessagePage fillSubject(String text) {
        driver.findElement(SUBJECT_FIELD).sendKeys(text);
        return this;
    }

    public MessagePage fillTextField(String text) {
        driver.findElement(TEXT_FIELD).sendKeys(text);
        return this;
    }

    public String getAddress() {
        return driver.findElement(ADDRESS_CONTENT).getDomAttribute("data-email");
    }

    public String getSubject() {
        return driver.findElement(SUBJECT_CONTENT).getAttribute("value");
    }

    public String getTextField() {
        return driver.findElement(TEXT_FIELD_CONTENT).getText();
    }

    public BoxPage sendMessageButton() {
        driver.findElement(SEND_BUTTON).click();
        return this;
    }
}
