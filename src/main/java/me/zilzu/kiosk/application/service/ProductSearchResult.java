package me.zilzu.kiosk.application.service;

public class ProductSearchResult {
    public Integer id;
    public String name;
    public Integer price;

    public ProductSearchResult(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
