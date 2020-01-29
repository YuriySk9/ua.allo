package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCatalogPage extends BasePage {
    private By productCatalogMenu = By.id("main-menu");
    private By displayBlock = By.xpath("//div[@class='menu-block menu-block-item' and @style='display: block;']");

    private By firstLevelLink(String categoryName) {
        return By.xpath(String.format("//a[@class='level-top'and contains(@href,'%s')]/ancestor::li", categoryName));
    }

    private By secondLevelLink(String categoryName) {
        return By.xpath(String.format("//a[contains(@class,'level2') and @href='%s']", categoryName));
    }

    public ProductCatalogPage(PageManager pages) {
        super(pages);
    }

    public ProductCatalogPage goToFirstLevel(String firstLevel) {
        Actions actions = new Actions(driver);
        if (!element(firstLevelLink("")).isDisplayed()) {
            actions.moveToElement(element(productCatalogMenu)).perform();
            wait.until(ExpectedConditions.attributeContains(productCatalogMenu, "class", "active"));
        }
        actions.moveToElement(element(firstLevelLink(firstLevel))).perform();
        return this;
    }

    public ProductCatalogPage goToSecondLevel(String secondLevel) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element(displayBlock).findElement(secondLevelLink(secondLevel))).click().perform();
        wait.until(ExpectedConditions.stalenessOf(element(displayBlock).findElement(secondLevelLink(secondLevel))));
        return this;
    }
}
