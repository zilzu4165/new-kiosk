package me.zilzu.kiosk.api.controller;

import java.util.List;

public class ProductSearchResultResponse {
    public Integer count;
    public List<ProductBasicResponse> products;

    public ProductSearchResultResponse(Integer count, List<ProductBasicResponse> products) {
        this.count = count;
        this.products = products;
    }
}
