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

    @GetMapping("/api/v1/products/search")
    public ProductSearchResultResponse searchProducts(@RequestParam String q,
                               @RequestParam(required = false) Integer priceMinRange,
                               @RequestParam(required = false) Integer priceMaxRange
    ) {
        List<ProductSearchResult> productSearchResults = productSearchService.search(q, priceMinRange, priceMaxRange);  // service layer에서 받은 객체를 다시 controller api 용 객체로 변환한다.
        List<ProductBasicResponse> productBasicResponses = productSearchResults.stream()                                // ProductSearchResult(service layer) -> ProductBasicResponse(controller layer)
                .map(product -> new ProductBasicResponse(product.id, product.name, product.price))
                .collect(Collectors.toList());

        return new ProductSearchResultResponse(productBasicResponses.size(), productBasicResponses);k
    }
}
