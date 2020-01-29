package tests;

import application.ApplicationManager;
import models.UserData;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {
    public ApplicationManager app;
    public UserData existingUser = new UserData().setLogin("tester125@gmail.com").setPassword("Test1111").setName("Юрий");

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void init(@Optional("chrome") String browser, ITestContext context) {
        app = new ApplicationManager(browser);
        app.getPopUpsHelper().dismissReceiveNotifications();
        app.getPopUpsHelper().acceptCity();
        context.setAttribute("app", app);
    }

    @AfterClass(alwaysRun = true)
    public void stop() {
        app.stop();
    }
}
