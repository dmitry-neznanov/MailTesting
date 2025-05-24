package org.example.mail.testing.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mail.testing.page.BoxPage;
import org.example.mail.testing.page.LoginPage;
import org.example.mail.testing.page.MessagePage;
import org.example.mail.testing.page.NavigatorPage;
import org.testng.Assert;

public class MailStepDef {
    @Given("I login to mail")
    public void iLoginToMail() {
        new LoginPage()
                .open()
                .pressLoginButton()
                .sendLogin()
                .pressEnterButton()
                .sendPass()
                .goToMail();
    }

    @When("I write message with subject {string} and text {string}")
    public void iWriteMessageWithSubjectAndText(String subject, String text) {
        MessagePage message = new NavigatorPage().pressWriteMessageButton();
        message.fillAddress()
                .choseAddress()
                .fillSubject(subject)
                .fillTextField(text);
    }

    @Then("I left it as draft")
    public void iLeftItAsDraft() {
        MessagePage draftMessage = new NavigatorPage().openDraftFolder();
        draftMessage = draftMessage.openDraftMessage();
        Assert.assertTrue(draftMessage.getDraftMessageInFolder().isDisplayed(),
                "Сообщения нет в черновике.");
        Assert.assertEquals(draftMessage.getAddress(),
                "login",
                "Получатель сообщения не совпадает");
        Assert.assertEquals(draftMessage.getSubject(),
                "test",
                "Тема сообщения не совпадает");
        Assert.assertEquals(draftMessage.getTextField(),
                "ВСЕМ ХАЙ",
                "Текст сообщения не совпадает");
    }

    @And("I send message from draft folder")
    public void iSendMessageFromDraftFolder() {
        new MessagePage().sendMessageButton();
    }

    @Then("Message disappears form draft folder")
    public void messageDisappearFormDraftFolder() {
        Assert.assertTrue(new MessagePage().isDraftMessageSent(),
                "Сообщение не исчезло из папки черновиков.");
    }

    @Then("Message appears in sent folder")
    public void messageAppearsInSendFolder() {
        BoxPage sentMessage = new NavigatorPage().openSentFolder();
        Assert.assertTrue(sentMessage.getSentMessageInFolder().isDisplayed(),
                "Сообщение нет в папке отправлено");
    }

    @And("I exit from account")
    public void iExitFromAccount() {
        new NavigatorPage()
                .openUserAccountMenu()
                .pressExitAccountButton()
                .pressConfirmExitButton();
    }
}
