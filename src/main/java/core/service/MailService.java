package core.service;

import app.business_objects.Mail;
import core.driver.singleton.WebDriverSingleton;
import org.openqa.selenium.By;

/**
 * Created by Dina_Abdykasheva on 8/17/2017.
 */
public class MailService {

    public boolean isMailPresent(By locator, Mail mail) {
        return WebDriverSingleton.getWebDriverInstance().findElement(locator).getText().equals(mail.getSubject());
    }
}
