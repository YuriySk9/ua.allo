package pages;

import org.openqa.selenium.By;

import java.util.List;

public class CartPage extends BasePage {
    private By products = By.xpath("//div[@class='title']//span[@class='wrap']");

    public CartPage(PageManager pages) {
        super(pages);
    }

    public CartPage ensurePageLoaded(){
        waitVisibilityOfElement(products);
        return this;
    }

    public List<String> getProducts() {
        return getStringList(products);
    }
}
