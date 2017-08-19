package app.pages;

import app.business_objects.Mail;
import core.driver.singleton.WebDriverSingleton;
import core.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import core.utils.Logger;

/**
 * Created by Dina_Abdykasheva on 6/15/2017.
 */
public class WriteMailPage extends AbstractPage {
    private static final By TO_FIELD_LOCATOR = By.name("to");
    private static final By SUBJECT_FIELD_LOCATOR = By.name("subjectbox");
    private static final By BODY_FIELD_LOCATOR = By.xpath(".//div[@role='textbox']");
    private static final By CLOSE_WRITE_MAIL_WINDOW_LOCATOR = By.xpath(".//img[@class='Ha']");
    private static final By SEND_MAIL_BUTTON_LOCATOR = By.xpath(".//div[@class = 'T-I J-J5-Ji aoO T-I-atl L3']");
    private static final By DRAFTS_FOLDER_LOCATOR = By.xpath(".//div[@class = 'TN GLujEb aHS-bnq']");
    private static final By SAVING_LABEL_LOCATOR = By.xpath(".//span[@class = 'oG aOy']");
    private static final By TO_FIELD_IN_DRAFT_LOCATOR = By.xpath(".//span[@class='vN bfK a3q']");
    private static final By MAIL_IS_SENT_LOCATOR = By.xpath(".//div[contains (text(), 'Письмо отправлено')]");
    private static final By DIALOG_WINDOW_LOCATOR = By.xpath(".//div[@role = 'dialog']");

    public DraftsFolderPage writeMailAndSaveToDraft(Mail mail) {
        Waiter.waitForElementPresent(ExpectedConditions.visibilityOfElementLocated(DIALOG_WINDOW_LOCATOR));
        Waiter.waitForElementPresent(ExpectedConditions.visibilityOfElementLocated(TO_FIELD_LOCATOR));
        WebDriverSingleton.getWebDriverInstance().findElement(TO_FIELD_LOCATOR).sendKeys(mail.getRecipient());
        WebDriverSingleton.getWebDriverInstance().findElement(SUBJECT_FIELD_LOCATOR).sendKeys(mail.getSubject());
        WebDriverSingleton.getWebDriverInstance().findElement(BODY_FIELD_LOCATOR).sendKeys(mail.getBody());
        Waiter.waitForElementPresent(ExpectedConditions.visibilityOfElementLocated(SAVING_LABEL_LOCATOR));
        WebDriverSingleton.getWebDriverInstance().findElement(CLOSE_WRITE_MAIL_WINDOW_LOCATOR).click();
        WebDriverSingleton.getWebDriverInstance().findElement(DRAFTS_FOLDER_LOCATOR).click();
        return new DraftsFolderPage();
    }

    public String getReceiver() {
        return WebDriverSingleton.getWebDriverInstance().findElement(TO_FIELD_IN_DRAFT_LOCATOR).getAttribute("email");
    }

    public String getSubject() {
        return WebDriverSingleton.getWebDriverInstance().findElement(SUBJECT_FIELD_LOCATOR).getAttribute("value");
    }

    public String getBody() {
        return WebDriverSingleton.getWebDriverInstance().findElement(BODY_FIELD_LOCATOR).getText();
    }

    public AccountPage sendMail() {
        WebDriverSingleton.getWebDriverInstance().findElement(SEND_MAIL_BUTTON_LOCATOR).click();
        Waiter.waitForElementPresent(ExpectedConditions.visibilityOfElementLocated(MAIL_IS_SENT_LOCATOR));
        Logger.info("Mail was successfully sent");
        return new AccountPage();
    }

}
