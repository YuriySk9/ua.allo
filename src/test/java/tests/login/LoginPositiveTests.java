package tests.login;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginPositiveTests extends BaseTest {
    @BeforeMethod
    public void beforeTest(){
        app.getUserHelper().logout();
    }

    @Test
    public void testLoginWithCorrectData() {
        app.getUserHelper().loginAs(existingUser).isUserLoggedIn();
        String userName = app.getUserHelper().getUserName();

        Assert.assertEquals(userName, existingUser.getName());
    }

    @AfterMethod
    public void afterTest(){
        app.getUserHelper().logout();
    }
}
