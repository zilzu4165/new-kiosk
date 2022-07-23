package me.zilzu.kiosk.api.controller;

public class ProductBasicResponse {
    public Integer productId;
    public String productName;
    public Integer productPrice;

    public ProductBasicResponse(Integer productId, String productName, Integer productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
