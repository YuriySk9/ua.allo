package tests.login;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.UserModel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LoginNegativeTests extends BaseTest {
    @BeforeMethod
    public void beforeTest() {
        app.getUserHelper().logout();
    }

    @AfterMethod
    public void afterTest() {
        app.getUserHelper().closeLoginWindow();
    }

    @DataProvider
    public Iterator<Object[]> invalidLoginData() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/testdata/login/testNegativeLogin.json")));){
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<UserModel> users = gson.fromJson(json, new TypeToken<List<UserModel>>(){}.getType()); // List<User>.class
            return users.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "invalidLoginData", invocationCount = 1)
    public void testNegativeLogin(UserModel user) {
        boolean isErrorMessage = app.getUserHelper().loginAs(user)
                .isErrorMessageAfterLogging();

        Assert.assertTrue(isErrorMessage);
    }
}
