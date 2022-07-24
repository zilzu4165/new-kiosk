package me.zilzu.kiosk.application.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSearchService {
    public List<ProductSearchResult> search(String productName, Integer priceMinRange, Integer priceMaxRange) {
        List<ProductSearchResult> results = new ArrayList<>();
        results.add(new ProductSearchResult(1111, "Commde", 100000));
        results.add(new ProductSearchResult(1112, "GUCCI", 160000));
        return results;
    }
}
