package me.zilzu.kiosk.api.controller;

public class ProductSaveResponse {
    public String result;
    public SingleProductSaveResultResponse product;

    public ProductSaveResponse(String result, SingleProductSaveResultResponse product) {
        this.result = result;
        this.product = product;
    }
}
