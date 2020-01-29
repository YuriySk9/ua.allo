package tests.filter;

import common.page.data.CommonCatalogData;
import common.page.data.CommonFilterData;
import models.FilterData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.BaseTest;

import java.util.List;

public class FilterTests extends BaseTest {
    @Test
    public void testFilterTrademarkAndPrice() {
        FilterData filterData = new FilterData().setBrand(CommonFilterData.Brand.lenovo)
                .setMinPrice(15000)
                .setMaxPrice(18000);

        app.getProductCatalogHelper().goToCategory(CommonCatalogData.all_notebooks);
        app.getFilterHelper().applyFilters(filterData);
        List<Integer> price = app.getProductListHelper().getCurrentlyPrice();
        List<String> names = app.getProductListHelper().getNames();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(names.stream().allMatch(x -> x.contains(filterData.getBrand().toLowerCase())),
                "Not all products contains \"" + filterData.getBrand() + "\"");
        softAssert.assertTrue(price.stream().allMatch(x -> (x >= filterData.getMinPrice() && x <= filterData.getMaxPrice())),
                "Not all product prices are between " + filterData.getMinPrice() + " and " + filterData.getMaxPrice() + ".");
        softAssert.assertAll();
    }
}