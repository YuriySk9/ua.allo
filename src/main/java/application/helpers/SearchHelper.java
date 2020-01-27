package application.helpers;

import application.ApplicationManager;

public class SearchHelper extends BaseHelper {
    public SearchHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public void search(String product) {
        pages.headerPage.ensurePageLoaded()
                .setSearchField(product)
                .clickFindButton();
        log("search: " + product);
    }
}
