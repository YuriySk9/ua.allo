package tests.login;

import common.page.data.CommonUserData;
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
        app.getUserHelper().loginAs(CommonUserData.user).isUserLoggedIn();
        String userName = app.getUserHelper().getUserName();

        Assert.assertEquals(userName, CommonUserData.user.getName());
    }

    @AfterMethod
    public void afterTest(){
        app.getUserHelper().logout();
    }
}
