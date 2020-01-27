package application.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import pages.PageManager;

import java.util.List;
import java.util.stream.Collectors;

public class BaseHelper {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;
    private int timeForWait = 10;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeForWait);
        pages = new PageManager(driver);
        Reporter.setEscapeHtml(false);
    }

    protected void log(String message) {
        Reporter.log(message + "<br>");
    }

    public List<String> toLowerList(List<String> list) {
        return list.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
    }
}
