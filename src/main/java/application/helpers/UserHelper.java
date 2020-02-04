package application.helpers;

import application.ApplicationManager;
import models.UserModel;

public class UserHelper extends BaseHelper {
    public UserHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public UserHelper loginAs(UserModel user) {
        pages.headerPage.ensurePageLoaded();
        if (!pages.loginPage.isOpen()) {
            pages.headerPage.clickSignInLink();
        }
        pages.loginPage.ensurePageLoaded()
                .setEmailField(user.getLogin())
                .setPasswordField(user.getPassword())
                .clickSubmitButton();
        log("login as: " + user);
        return this;
    }

    public boolean isErrorMessageAfterLogging() {
        boolean isErrorMessage = pages.loginPage.ensurePageLoaded()
                .isErrorMessage();
        log("is error message? - " + isErrorMessage);
        return isErrorMessage;
    }

    public boolean isUserLoggedIn() {
        boolean userLoggedIn = pages.headerPage.ensurePageLoaded()
                .isUserLoggedIn();
        log("is user logged in? - " + userLoggedIn);
        return userLoggedIn;
    }

    public String getUserName() {
        String userName = pages.headerPage.getUserName();
        log("user name: " + userName);
        return userName;
    }

    public void logout() {
        boolean isUserLoggedIn = pages.headerPage.ensurePageLoaded()
                .isUserLoggedIn();
        if (isUserLoggedIn) {
            pages.headerPage.clickLogoutButton();
            log("logout");
        }
    }

    public void closeLoginWindow() {
        if (pages.loginPage.isOpen()) {
            pages.loginPage.ensurePageLoaded()
                    .clickCloseWindow();
            log("close login window");
        }
    }
}
