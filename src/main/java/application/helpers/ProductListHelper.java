package application.helpers;

import application.ApplicationManager;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListHelper extends BaseHelper {
    public ProductListHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public String addFirstProductToCart(String product) {
        String productName = pages.productListPage.ensurePageLoaded()
                .clickFirstAddToCartButton();
        pages.modalCartPage.ensurePageLoaded()
                .clickCloseButton();
        log("add product to the cart: " + productName);
        return productName;
    }

    public List<String> getNames() {
        List<String> products = pages.productListPage.ensurePageLoaded()
                .getProductNameList();
        products = products.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        log("products on the product list page: " + products);
        return products;
    }

    public List<Integer> getCurrentlyPrice() {
        List<String> price = pages.productListPage
                .ensurePageLoaded()
                .getPrice();
        List<String> priceWithoutSpaces = price
                .stream().map(s -> s.replaceAll(" ", ""))
                .collect(Collectors.toList());
        List<Integer> priceToInt = priceWithoutSpaces
                .stream().map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
        return priceToInt;
    }
}
