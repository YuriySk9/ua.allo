package models;

public class FilterData {
    private int minPrice;
    private int maxPrice;
    private String brand;
    private String diagonal;

    public int getMinPrice() {
        return minPrice;
    }
    public FilterData setMinPrice(int minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public int getMaxPrice() {
        return maxPrice;
    }
    public FilterData setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public String getBrand() {
        return brand;
    }
    public FilterData setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getDiagonal() {
        return diagonal;
    }
    public FilterData setDiagonal(String diagonal) {
        this.diagonal = diagonal;
        return this;
    }
}
