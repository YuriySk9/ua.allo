package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By emailField = By.id("auth");
    private By passwordField = By.id("v-login-password");
    private By submitButton = By.xpath("//button[@class='modal-submit-button']");
    private By errorMessage = By.xpath("//div[@class='validation-advice v-validation-error']");
    private By loadingModalRequest = By.xpath("//div[@class='loading-modal-request']");

    public LoginPage(PageManager pages) {
        super(pages);
    }

    public LoginPage setEmailField(String email) {
        type(emailField, email);
        return this;
    }

    public LoginPage setPasswordField(String password) {
        type(passwordField, password);
        return this;
    }

    public void clickSubmitButton(){
        WebElement loginButton = element(submitButton);
        loginButton.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.stalenessOf(loginButton),
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        ));
    }

    public boolean isOpen() {
        return isElementPresent(emailField);
    }

    public boolean isErrorMessage(){
        return isElementPresent(errorMessage);
    }

    public LoginPage ensurePageLoaded() {
        waitVisibilityOfElement(emailField);
        wait.until(d -> elements(loadingModalRequest).isEmpty());
        return this;
    }
}
