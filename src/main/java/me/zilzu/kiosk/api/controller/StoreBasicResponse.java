package me.zilzu.kiosk.api.controller;

public class StoreBasicResponse {
    public String storeId;
    public String storeName;
    public String storeDescription;

    public StoreBasicResponse(String storeId, String storeName, String storeDescription) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeDescription = storeDescription;
    }
}
