package app.pages;

import app.business_objects.Mail;
import core.driver.singleton.WebDriverSingleton;
import core.service.GlobalProperties;
import core.service.MailService;
import org.openqa.selenium.By;

/**
 * Created by Dina_Abdykasheva on 6/16/2017.
 */
public class DraftsFolderPage extends AbstractPage {
    private static final By DRAFT_MAIL_LOCATOR = By.className("bog");

    public boolean isDraftMailDisplayed(Mail mail) {
        return new MailService().isMailPresent(DRAFT_MAIL_LOCATOR, mail);
    }

    public WriteMailPage openDraftMail() {
        WebDriverSingleton.getWebDriverInstance().findElement(DRAFT_MAIL_LOCATOR).click();
        return new WriteMailPage();
    }
}
