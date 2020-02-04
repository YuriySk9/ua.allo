package models;

public class FilterModel {
    private int minPrice;
    private int maxPrice;
    private String brand;
    private String diagonal;

    public int getMinPrice() {
        return minPrice;
    }
    public FilterModel setMinPrice(int minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public int getMaxPrice() {
        return maxPrice;
    }
    public FilterModel setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public String getBrand() {
        return brand;
    }
    public FilterModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getDiagonal() {
        return diagonal;
    }
    public FilterModel setDiagonal(String diagonal) {
        this.diagonal = diagonal;
        return this;
    }

    @Override
    public String toString() {
        return "FilterModel{" +
                "minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", brand='" + brand + '\'' +
                ", diagonal='" + diagonal + '\'' +
                '}';
    }
}
