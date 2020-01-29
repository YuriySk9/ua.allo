package tests.cart;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddProductToCart extends BaseTest {
    @BeforeMethod
    public void beforeTest() {
        app.getCartHelper().clear();
    }

    @AfterMethod
    public void afterTest() {
        app.getCartHelper().clear();
    }

    @Test
    public void testAddProductToCart() {
        String product = "Планшет Samsung TAB A";

        int countBefore = app.getCartHelper().getProductsCount();
        app.getSearchHelper().search(product);
        product = app.getProductListHelper().addFirstProductToCart(product);
        int countAfter = app.getCartHelper().getProductsCount();
        assertEquals(countBefore, countAfter - 1);
        app.getCartHelper().open();
        List<String> productInCart = app.getCartHelper().getProductList();

        assertTrue(productInCart.contains(product), "expected: " + product + ", but was: " + productInCart);
    }
}
