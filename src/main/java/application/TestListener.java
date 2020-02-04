package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    Logger logger = LoggerFactory.getLogger(TestListener.class);

    private String testName;
    private String testMethodName;

    @Override
    public void onTestStart(ITestResult result) {
        this.testMethodName = result.getMethod().getMethodName();
        logger.info("[START " + testMethodName + "]");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        this.testMethodName = result.getMethod().getMethodName();
        logger.info("[TEST " + testMethodName + " PASSED]");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        this.testMethodName = result.getMethod().getMethodName();
        logger.info("[TEST " + testMethodName + " FAILED]");
        ApplicationManager app = (ApplicationManager) result.getTestContext().getAttribute("app");
        app.takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        testName = context.getCurrentXmlTest().getName();
        logger = LoggerFactory.getLogger(testName);
        logger.info("[TEST " + testName + " STARTED]");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("[ALL " + testName + " FINISHED]");
    }
}
