package org.example.mail.testing.runner;

import org.example.mail.testing.po.BoxPage;
import org.example.mail.testing.po.LoginPage;
import org.example.mail.testing.po.MessagePage;
import org.example.mail.testing.po.NavigatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MailTest {
    private WebDriver driver;

    @BeforeClass(description = "Start browser")
    private void startBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void loginToMailAndSendMessageFromDraftTest() {
        NavigatorPage navigatorPage = new LoginPage(driver)
                .open()
                .pressLoginButton()
                .sendLogin()
                .pressEnterButton()
                .sendPass()
                .goToMail();

        MessagePage message = navigatorPage.pressWriteMessageButton();
        message.fillAddress()
                .choseAddress()
                .fillSubject("test")
                .fillTextField("ВСЕМ ХАЙ");

        MessagePage draftMessage = new NavigatorPage(driver).openDraftFolder();
        Assert.assertTrue(draftMessage.getDraftMessageInFolder().isDisplayed(),
                "Сообщения нет в черновике.");
        draftMessage = draftMessage.openDraftMessage();

        Assert.assertEquals(message.getAddress(),
                "login",
                "Получатель сообщения не совпадает");
        Assert.assertEquals(message.getSubject(),
                "test",
                "Тема сообщения не совпадает");
        Assert.assertEquals(message.getTextField(),
                "ВСЕМ ХАЙ",
                "Текст сообщения не совпадает");

        draftMessage.sendMessageButton();
        Assert.assertTrue(draftMessage.isDraftMessageSent(),
                "Сообщение не исчезло из папки черновиков.");

        BoxPage sentMessage = new NavigatorPage(driver).openSentFolder();
        Assert.assertTrue(sentMessage.getSentMessageInFolder().isDisplayed(),
                "Сообщение нет в папке отправлено");

        new NavigatorPage(driver)
                .openUserAccountMenu()
                .pressExitAccountButton()
                .pressConfirmExitButton();
    }

    /*@AfterClass
    public void stopBrowser() {
        driver.quit();
    }*/


}
