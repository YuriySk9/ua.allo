package application.helpers;

import application.ApplicationManager;
import models.ProductCatalogData;

public class ProductCatalogHelper extends BaseHelper {
    public ProductCatalogHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public void goToCategory(ProductCatalogData category) {
        pages.headerPage.ensurePageLoaded();
        pages.productCatalogPage.goToFirstLevel(category.getFirstLevel());
        pages.productCatalogPage.goToSecondLevel(category.getSecondLevel());
    }
}
