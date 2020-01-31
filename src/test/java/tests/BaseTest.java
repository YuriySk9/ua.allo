package tests;

import application.ApplicationManager;
import models.UserData;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {
    public ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    public UserData existingUser = new UserData().setLogin("tester125@gmail.com").setPassword("Test1111").setName("Юрий");

    @BeforeClass(alwaysRun = true)
    public void init(ITestContext context) {
        app.getPopUpsHelper().dismissReceiveNotifications();
        app.getPopUpsHelper().acceptCity();
        context.setAttribute("app", app);
    }

    @AfterClass(alwaysRun = true)
    public void stop() {
        app.stop();
    }
}
