package test;

import app.business_objects.Mail;
import app.business_objects.User;
import app.pages.AccountPage;
import app.pages.LoginToGMailPage;
import app.pages.SentFolderPage;
import app.pages.SentMailPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by User on 06.08.2017.
 */
public class DeleteSentMailTest extends BaseTest {
    public AccountPage accountPage;
    public SentFolderPage sentFolderPage;
    public SentMailPage sentMailPage;
    public Mail mail;

    @Test(description = "loginToAccountTest", priority = 0)
    @Parameters({"username", "password"})
    public void loginToAccountTest(String username, String password) {
        accountPage = new LoginToGMailPage().loginToGMail(new User(username, password));
        boolean isAccountIconPresent = accountPage.isAccountIconPresent();
        Assert.assertTrue(isAccountIconPresent, "User isn't logged in");
    }

    @Test(description = "verifySentMail", dependsOnMethods = "loginToAccountTest")
    public void verifySentMail() {
        sentFolderPage = accountPage.openSentMail();
        boolean isMailSent = sentFolderPage.isMailSent(mail);
        Assert.assertTrue(isMailSent, "Mail wasn't sent");
    }

    @Test(description = "deleteSentMail", dependsOnMethods = "verifySentMail")
    public void deleteSentMail() {
        sentMailPage = sentFolderPage.openSentMail().deleteSentMail();
        boolean isMailDeleted = sentMailPage.isMailDeleted();
        Assert.assertTrue(isMailDeleted, "Mail wasn't deleted");

    }
}

