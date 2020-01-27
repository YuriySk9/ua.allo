package tests.search;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;

public class SearchProductTests extends BaseTest {

    @DataProvider(name = "validDate")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"apple iphone 11"},
                {"Ноутбук Lenovo IdeaPad 330-15"},
                {"Орбітрек"}};
    }

    @Test(dataProvider = "validDate")
    public void testSearchProduct(String product){
        product = product.toLowerCase();

        app.getSearchHelper().search(product);
        List<String> productList = app.getProductListHelper().getProductList();

        assertThat(productList, (everyItem(containsString(product))));
    }
}
