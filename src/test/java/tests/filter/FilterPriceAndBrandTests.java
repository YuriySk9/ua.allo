package tests.filter;

import common.page.data.CommonCatalogData;
import common.page.data.CommonFilterData;
import models.FilterModel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.BaseTest;

import java.util.List;

public class FilterPriceAndBrandTests extends BaseTest {
    @Test
    public void testFilterTrademarkAndPrice() {
        FilterModel filterModel = new FilterModel().setBrand(CommonFilterData.Brand.lenovo)
                .setMinPrice(15000)
                .setMaxPrice(18000);

        app.getProductCatalogHelper().goToCategory(CommonCatalogData.all_notebooks);
        app.getFilterHelper().applyFilters(filterModel);
        List<Integer> price = app.getProductListHelper().getCurrentlyPrice();
        List<String> names = app.getProductListHelper().getNames();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(names.stream().allMatch(x -> x.contains(filterModel.getBrand().toLowerCase())),
                "Not all products contains \"" + filterModel.getBrand() + "\"");
        softAssert.assertTrue(price.stream().allMatch(x -> (x >= filterModel.getMinPrice() && x <= filterModel.getMaxPrice())),
                "Not all product prices are between " + filterModel.getMinPrice() + " and " + filterModel.getMaxPrice() + ".");
        softAssert.assertAll();
    }
}