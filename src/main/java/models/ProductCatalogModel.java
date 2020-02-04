package models;

public class ProductCatalogModel {
    private String firstLevel;
    private String secondLevel;

    public String getFirstLevel() {
        return firstLevel;
    }
    public ProductCatalogModel setFirstLevel(String level1) {
        this.firstLevel = level1;
        return this;
    }

    public String getSecondLevel() {
        return secondLevel;
    }
    public ProductCatalogModel setSecondLevel(String secondLevel) {
        this.secondLevel = secondLevel;
        return this;
    }

    @Override
    public String toString() {
        return "ProductCatalogData{" +
                "firstLevel='" + firstLevel + '\'' +
                ", secondLevel='" + secondLevel + '\'' +
                '}';
    }
}
