package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListPage extends BasePage {
    private By productName = By.xpath("//a[@class='product-name multiple-lines-crop']");
    private By noResultLabel = By.xpath("//div[@class='no-result']");
    private By buyButtons = By.xpath("//button[@class='buy small ']");
    private By productsNamesWithBuyButton = By.xpath("//button[@class='buy small ']/preceding::a[@class='product-name multiple-lines-crop'][1]");
    private By currentlyPriceLabel = By.xpath("//li[contains(@id,'item')]//span[@class='regular-price']//span[contains(@class,'sum')]");//1 price

    public ProductListPage(PageManager pages) {
        super(pages);
    }

    public ProductListPage ensurePageLoaded() {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfAllElementsLocatedBy(productName),
                ExpectedConditions.visibilityOfElementLocated(noResultLabel)));
        return this;
    }

    public List<String> getProductNameList() {
        return getStringList(productName);
    }

    public String clickFirstAddToCartButton() {
        String product = elements(productsNamesWithBuyButton).get(0).getAttribute("title");
        elements(buyButtons).get(0).click();
        return product;
    }

    public List<String> getPrice() {
        List<String> price = elements(currentlyPriceLabel)
                .stream().map(x -> x.getText())
                .collect(Collectors.toList());
        return price;
    }
}
