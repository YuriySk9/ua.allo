package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterPage extends BasePage {
    private By minPriceField = By.name("price_from");
    private By manPriceField = By.name("price_to");
    private By okButton = By.id("price_slider_submit");

    private By checkBoxForChecking(String brand) {
        return By.xpath(String.format("//label[text()='%s']/preceding-sibling::input[@class='gan-checkbox']", brand));
    }

    private By checkBoxForClick(String text) {
        return By.xpath(String.format("//label[text()='%s']", text));
    }

    public FilterPage(PageManager pages) {
        super(pages);
    }

    public FilterPage setMinAndMaxPrice(int minPrice, int maxPrice) {
        type(minPriceField, String.valueOf(minPrice));
        type(manPriceField, String.valueOf(maxPrice));
        return this;
    }

    public FilterPage clickOkButton() {
        WebElement ok = element(okButton);
        ok.click();
        wait.until(ExpectedConditions.stalenessOf(ok));
        return this;
    }

    public void selectCheckBox(String text) {
        if (text != null) {
            if (!element(checkBoxForChecking(text)).isSelected()) {
                WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(element(checkBoxForClick(text))));
                checkBox.click();
                wait.until(ExpectedConditions.stalenessOf(checkBox));
            }
        }
    }

    public FilterPage ensurePageLoaded() {
        waitVisibilityOfElement(minPriceField);
        return this;
    }
}