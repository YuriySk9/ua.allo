package application.helpers;

import application.ApplicationManager;
import models.FilterModel;

public class FilterHelper extends BaseHelper {
    public FilterHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public void applyFilters(FilterModel filters) {
        pages.filterPage.ensurePageLoaded()
                .setMinAndMaxPrice(filters.getMinPrice(), filters.getMaxPrice())
                .clickOkButton()
                .selectCheckBox(filters.getBrand());
        log("apply filters: " + filters);
    }
}
