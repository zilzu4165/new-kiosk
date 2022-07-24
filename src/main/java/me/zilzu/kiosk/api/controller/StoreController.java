package me.zilzu.kiosk.api.controller;

import me.zilzu.kiosk.application.service.ProductSearchResult;
import me.zilzu.kiosk.application.service.ProductSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StoreController {

    private final ProductSearchService productSearchService;

    public StoreController(ProductSearchService productSearchService) {
        this.productSearchService = productSearchService;
    }

    @GetMapping("/api/v1/stores/{storeId}")
    public StoreBasicResponse getStore(@PathVariable String storeId) {
        return new StoreBasicResponse(storeId, "엄지손칼국수", "홍두깨로 직접하는 손칼국수");
    }


}
