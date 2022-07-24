package me.zilzu.kiosk.api.controller;


public class ProductSaveResultResponse {
    public String result;
    public SingleProductSaveResultResponse product;

    public ProductSaveResultResponse(String result, SingleProductSaveResultResponse product) {
        this.result = result;
        this.product = product;
    }
}
