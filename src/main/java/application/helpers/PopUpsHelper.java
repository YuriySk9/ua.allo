package application.helpers;

import application.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PopUpsHelper extends BaseHelper {
    public PopUpsHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public void acceptCity() {
        By accept = By.xpath("//button[@class='confirm-city']");
        if (!driver.findElements(accept).isEmpty()) ;
        {
            wait.until(ExpectedConditions.elementToBeClickable(accept)).click();
        }
    }

    public void dismissReceiveNotifications() {
        By receiveNotification = By.xpath("//button[@class='push-notification-prompt-btn push-notification-disallow-btn']");
        if (!driver.findElements(receiveNotification).isEmpty()) ;
        {
            wait.until(ExpectedConditions.elementToBeClickable(receiveNotification)).click();
        }
    }
}
