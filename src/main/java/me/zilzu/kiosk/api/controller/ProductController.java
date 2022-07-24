package me.zilzu.kiosk.api.controller;

import me.zilzu.kiosk.application.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductSaveService productSaveService;
    private final ProductSearchService productSearchService;

    public ProductController(ProductSaveService productSaveService, ProductSearchService productSearchService) {
        this.productSaveService = productSaveService;
        this.productSearchService = productSearchService;
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

        return new ProductSearchResultResponse(productBasicResponses.size(), productBasicResponses);
    }


//    {
//        "result": "REGISTERED",
//            "productSaveRequest": {
//               "productName": "헤지스지갑",
//               "category": "지갑",
//               "price": 170000
//            }
//    }
    @PostMapping("api/v1/product")
    public ProductSaveResponse saveProduct(@RequestBody ProductSaveRequest productSaveRequest) {
        Product product = new Product(productSaveRequest.productName, productSaveRequest.category, productSaveRequest.price);
        ProductSaveResult result = productSaveService.save(product);

        return new ProductSaveResponse("RESISTERED", new SingleProductSaveResultResponse(result.productName, result.category, result.price));
    }

//    {
//        "result": "REGISTERED",
//            "productList":
//        [
//        {
//            "productName": "헤지스지갑",
//                "category": "지갑",
//                "price": 170000
//        },
//        {
//            "productName": "구찌지갑",
//                "category": "지갑",
//                "price": 190000
//        }
//        ]
//    }
    @PostMapping("api/v1/products")
    public ProductBatchSaveResponse saveProducts(@RequestBody List<ProductSaveRequest> productSaveRequests) {
        List<Product> products = productSaveRequests.stream()
                .map(saveRequest -> new Product(saveRequest.productName, saveRequest.category, saveRequest.price))
                .collect(Collectors.toList());

        List<ProductSaveResult> productSaveResults = productSaveService.saveList2(products);

        List<SingleProductSaveResultResponse> saveResultResponses = productSaveResults.stream()
                .map(saveResults -> new SingleProductSaveResultResponse(saveResults.productName, saveResults.category, saveResults.price)).collect(Collectors.toList());

        return new ProductBatchSaveResponse("REGISTERED", saveResultResponses);
    }

}
