package me.zilzu.kiosk.api.controller;

import java.util.List;

public class ProductBatchSaveResponse {
    public String result;
    public List<SingleProductSaveResultResponse> productList;

    public ProductBatchSaveResponse(String result, List<SingleProductSaveResultResponse> productSaveResponses) {
        this.result = result;
        this.productList = productSaveResponses;
    }
}
