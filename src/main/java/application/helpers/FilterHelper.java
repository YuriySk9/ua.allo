package application.helpers;

import application.ApplicationManager;
import models.FilterData;

public class FilterHelper extends BaseHelper {
    public FilterHelper(ApplicationManager app) {
        super(app.getWebDriver());
    }

    public void applyFilters(FilterData filters) {
        pages.filterPage.ensurePageLoaded()
                .setMinAndMaxPrice(filters.getMinPrice(), filters.getMaxPrice())
                .clickOkButton()
                .selectCheckBox(filters.getBrand());
    }
}
