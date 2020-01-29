package application.helpers;

import application.ApplicationManager;

import java.util.List;

public class CartHelper extends BaseHelper {
    private String url = "https://allo.ua/ua/checkout/cart/";

    public CartHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public CartHelper open() {
        if (!pages.cartPage.isCartOpen()) {
            driver.get(url);
        }
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

    public void clear() {
        if (pages.cartPage.isCartOpen()) {
            if (!pages.cartPage.isCartEmpty()) {
                while (!pages.cartPage.isCartEmpty()) {
                    pages.cartPage.clickDeleteButton("");
                }
            }
        } else {
            if (pages.headerPage.ensurePageLoaded().productCountInCart() > 0) {
                open();
                pages.cartPage.ensurePageLoaded();
                while (!pages.cartPage.isCartEmpty()) {
                    pages.cartPage.clickDeleteButton("");
                }
            }
        }
    }
}
