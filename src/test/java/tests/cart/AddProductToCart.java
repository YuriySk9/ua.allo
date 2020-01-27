package tests.cart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static org.testng.Assert.*;

public class AddProductToCart extends BaseTest {

    @BeforeMethod
    public void beforeTest() {

    }

    @Test
    public void testAddProductToCart() {
        String product = "Планшет Samsung TAB A";

        int countBefore = app.getCartHelper().getProductsCount();
        app.getSearchHelper().search(product);
        product = app.getProductListHelper().addFirstProductToCart(product);
        int countAfter = app.getCartHelper().getProductsCount();
        assertEquals(countBefore, countAfter -1);
        List<String> productInCart = app.getCartHelper().open().getProductList();

        assertTrue(productInCart.contains(product), "expected: " + product + ", but was: " + productInCart);

    }
}
