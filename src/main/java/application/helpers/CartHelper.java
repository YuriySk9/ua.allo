package application.helpers;

import application.ApplicationManager;

import java.util.List;

public class CartHelper extends BaseHelper {
    public CartHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public CartHelper open() {
        pages.headerPage.ensurePageLoaded()
                .clickCartLink();
        log("cart page is open");
        return this;
    }

    public int getProductsCount() {
        int count = pages.headerPage.ensurePageLoaded()
                .productCountInCart();
        log("product count in cart: " + count);
        return count;
    }

    public List<String> getProductList() {
        List<String> products = pages.cartPage.ensurePageLoaded()
                .getProducts();
        log("products in the cart: " + products);
        return products;
    }
}
