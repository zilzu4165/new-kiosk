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
        // 가게 정보를 가져온다.
        return new StoreBasicResponse(storeId, "엄지칼국수", "칼국수 존맛");
    }

    // GET ~/api/v1/products/search?q=지갑&priceMinRange=100000&priceMaxRange=200000
    // Response
//    { count : 2
//    products : [
//    {
//        id : 1273,
//        name : ~~~,
//        price : 100000
//    }]
//     }

    // count ?
    @GetMapping("/api/v1/products/search")
    public ProductSearchResultResponse searchProducts(
            @RequestParam String productName,
            @RequestParam(required = false) Integer priceMinRange,
            @RequestParam(required = false) Integer priceMaxRange
    ) {

        List<ProductSearchResult> searchResults = productSearchService.search(productName, priceMinRange, priceMaxRange);
        List<ProductBasicResponse> basicResponseList = searchResults
                .stream()
                .map(searchResult -> new ProductBasicResponse(searchResult.id, searchResult.name, searchResult.price))
                .collect(Collectors.toList());

        return new ProductSearchResultResponse(searchResults.size(), basicResponseList);
    }
}
