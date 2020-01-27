package tests.login;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginPositiveCaseTests extends BaseTest {

    @BeforeMethod
    public void beforeTest(){
        app.getUserHelper().logout();
    }

    @Test
    public void testLoginWithCorrectData() {
        app.getUserHelper().loginAs(user).isUserLoggedIn();
        String userName = app.getUserHelper().getUserName();

        Assert.assertEquals(userName, user.getName());
    }

    @AfterMethod
    public void afterTest(){
        app.getUserHelper().logout();
    }
}
