package models;

public class ProductCatalogData {
    private String firstLevel;
    private String secondLevel;

    public String getFirstLevel() {
        return firstLevel;
    }
    public ProductCatalogData setFirstLevel(String level1) {
        this.firstLevel = level1;
        return this;
    }

    public String getSecondLevel() {
        return secondLevel;
    }
    public ProductCatalogData setSecondLevel(String secondLevel) {
        this.secondLevel = secondLevel;
        return this;
    }
}
