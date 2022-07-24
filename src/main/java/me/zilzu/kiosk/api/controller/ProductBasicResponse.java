package me.zilzu.kiosk.api.controller;

public class ProductBasicResponse {
    public Integer id;
    public String name;
    public Integer price;

    public ProductBasicResponse(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
