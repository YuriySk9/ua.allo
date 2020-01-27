package tests;

import application.ApplicationManager;
import models.User;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    public ApplicationManager app;
    public User user = new User().setLogin("tester125@gmail.com").setPassword("Test1111").setName("Юрий");

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void init(@Optional("chrome") String browser, ITestContext context) {
        app = new ApplicationManager(browser);
        context.setAttribute("app", app);
    }

    @AfterClass(alwaysRun = true)
    public void stop() {
        app.stop();
    }
}
