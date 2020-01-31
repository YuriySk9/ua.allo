package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected PageManager pages;
    protected WebDriver driver;
    protected WebDriverWait wait;
    private int timeForWait = 10;

    public BasePage(PageManager pages) {
        this.pages = pages;
        driver = pages.getWebDriver();
        wait = new WebDriverWait(driver, timeForWait);
    }

    protected void type(By locator, String text) {
        if (text != null) {
            String oldText = element(locator).getText();
            if (!text.equals(oldText)) {
                element(locator).click();
                element(locator).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                element(locator).sendKeys(text);
            }
        }
    }

    protected WebElement element(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> elements(By locator) {
        return driver.findElements(locator);
    }

    protected boolean isElementPresent(By locator) {
        if (!elements(locator).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean waitVisibilityOfElement(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            e.getMessage();
            return false;
        }
    }

    protected List<String> getStringList(By locator) {
        List<String> productNameList = new ArrayList<>();
        List<WebElement> productNamesList = elements(locator);
        for (WebElement product : productNamesList) {
            productNameList.add(product.getText());
        }
        return productNameList;
    }
}
