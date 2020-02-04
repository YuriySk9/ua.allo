package tests;

import application.ApplicationManager;
import application.TestListener;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {
    public ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

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
