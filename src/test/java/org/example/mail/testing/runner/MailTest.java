package org.example.mail.testing.runner;

import org.example.mail.testing.page.BoxPage;
import org.example.mail.testing.page.LoginPage;
import org.example.mail.testing.page.MessagePage;
import org.example.mail.testing.page.NavigatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailTest {


    @Test
    public void loginToMailAndSendMessageFromDraftTest() {
        NavigatorPage navigatorPage = new LoginPage()
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

        MessagePage draftMessage = new NavigatorPage().openDraftFolder();
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

        BoxPage sentMessage = new NavigatorPage().openSentFolder();
        Assert.assertTrue(sentMessage.getSentMessageInFolder().isDisplayed(),
                "Сообщение нет в папке отправлено");

        new NavigatorPage()
                .openUserAccountMenu()
                .pressExitAccountButton()
                .pressConfirmExitButton();
    }

}
