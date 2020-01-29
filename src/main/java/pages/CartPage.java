package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {
    private By products = By.xpath("//div[@class='title']//span[@class='wrap']");
    private By emptyCartLabel = By.xpath("//div[@class='cart-popup_empty']");
    private By cartLabelInLeftMenu = By.xpath("//li[@class='without-child-current']");

    private By deleteButton(String name) {
        return By.xpath(String.format("//span[contains(text(),'%s')]/ancestor::div[@class='title']/i", name));
    }

    public CartPage(PageManager pages) {
        super(pages);
    }

    public CartPage ensurePageLoaded() {
        waitVisibilityOfElement(products);
        return this;
    }

    public List<String> getProducts() {
        return getStringList(products);
    }

    public void clickDeleteButton(String name) {
        WebElement delete = element(deleteButton(name));
        delete.click();
        wait.until(ExpectedConditions.stalenessOf(delete));
    }

    public boolean isCartEmpty() {
        if (elements(emptyCartLabel).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isCartOpen() {
        if (!elements(cartLabelInLeftMenu).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
