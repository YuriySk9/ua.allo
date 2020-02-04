package common.page.data;

import models.ProductCatalogModel;

public class CommonCatalogData {
        public static ProductCatalogModel all_notebooks = new ProductCatalogModel(
        ).setFirstLevel("//allo.ua/ua/planshety-i-gadzhety/").setSecondLevel("//allo.ua/ua/products/notebooks/");

        public static ProductCatalogModel tv_Samsung = new ProductCatalogModel(
        ).setFirstLevel("//allo.ua/ua/televizory-i-mediapleery/").setSecondLevel("//allo.ua/ua/televizory/proizvoditel-samsung/");
}
