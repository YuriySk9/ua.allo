package tests.login;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginNegativeCasesTests extends BaseTest {

    @BeforeMethod
    public void beforeTest() {
        app.getUserHelper().logout();
    }

    @DataProvider(name = "invalidDate")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {new User().setLogin("tester125@gmail.com").setPassword("test1111").setName("Юрий")},
                {new User().setLogin("tester125@gmail.com").setPassword("test1111").setName("Юрий")}};
    }

    @Test(dataProvider = "invalidDate")
    public void testLoginWithInCorrectData(User user) {
        boolean isErrorMessage = app.getUserHelper().loginAs(user)
                .isErrorMessageAfterLogging();

        Assert.assertTrue(isErrorMessage);
    }
}
