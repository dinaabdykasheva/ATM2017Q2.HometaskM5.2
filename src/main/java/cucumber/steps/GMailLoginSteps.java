package cucumber.steps;

import app.business_objects.Mail;
import app.business_objects.User;
import app.pages.*;
import core.driver.singleton.WebDriverSingleton;
import core.service.GlobalProperties;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Parameters;

/**
 * Created by Dina_Abdykasheva on 8/21/2017.
 */
public class GMailLoginSteps {
    public DraftsFolderPage writeMail, openDraftFolder;
    public WriteMailPage openSavedDraft;
    public SentFolderPage sendMail;
    public LoginToGMailPage exitGMail;
    public AccountPage accountPage;
    public Mail mail;

    @Given("^user navigates to GMail start page$")
    public void navigateToStartPage() {
        WebDriverSingleton.getWebDriverInstance().get(GlobalProperties.URL);
    }

    @When("^user enters (.*) and (.*)$")
    public void enterUserLoginAndPassword(String username, String password) {
        accountPage = new LoginToGMailPage().loginToGMail(new User(username, password));

    }

    @Then("^GMail account page is displayed$")
    public void verifyGMailAccountPageIsDisplayed() {
        boolean isAccountIconPresent = accountPage.isAccountIconPresent();
        Assert.assertTrue(isAccountIconPresent, "User isn't logged in");
    }

    @When("^user fills in (.*), (.*), (.*) fields of mail and save mail to draft$")
    public void fillInMailFields(String recipient, String subject, String body) {
        mail = new Mail(recipient, subject, body);
        writeMail = accountPage.clickWriteMailButton().writeMailAndSaveToDraft(mail);
    }

    @Then("^mail appears in drafts folder$")
    public void verifyMailSavedInDrafts() {
        boolean isDraftMailSaved = writeMail.isDraftMailDisplayed(mail);
        Assert.assertTrue(isDraftMailSaved, "mentoring task");
    }
}
