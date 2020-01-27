package application.helpers;

import application.ApplicationManager;

import java.util.List;

public class ProductListHelper extends BaseHelper {
    public ProductListHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public List<String> getProductList() {
        List<String> products = toLowerList(pages.productListPage.ensurePageLoaded()
                .getProductList());
        log("products on the product list page: " + products);
        return products;
    }

    public String addFirstProductToCart(String product) {
        String productName = pages.productListPage.ensurePageLoaded()
                .clickFirstAddToCartButton();
        pages.modalCartPage.ensurePageLoaded()
                .clickCloseButton();
        log("add product to the cart: " + productName);
        return productName;
    }
}
