package me.zilzu.kiosk.api.controller;

public class SingleProductSaveResultResponse {
    public String productName;
    public String category;
    public Integer price;

    public SingleProductSaveResultResponse(String productName, String category, Integer price) {
        this.productName = productName;
        this.category = category;
        this.price = price;
    }
}
