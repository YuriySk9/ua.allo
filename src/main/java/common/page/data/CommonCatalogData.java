package common.page.data;

import models.ProductCatalogData;

public class CommonCatalogData {
        public static ProductCatalogData all_notebooks = new ProductCatalogData(
        ).setFirstLevel("//allo.ua/ua/planshety-i-gadzhety/").setSecondLevel("//allo.ua/ua/products/notebooks/");

        public static ProductCatalogData tv_Samsung = new ProductCatalogData(
        ).setFirstLevel("//allo.ua/ua/televizory-i-mediapleery/").setSecondLevel("//allo.ua/ua/televizory/proizvoditel-samsung/");
}
