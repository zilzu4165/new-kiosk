package me.zilzu.kiosk.application.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSaveService {

    public ProductSaveResult save(Product product) {
        return new ProductSaveResult(product.name, product.category, product.price);
    }

    public List<ProductSaveResult> saveList(List<Product> products) {
        List<ProductSaveResult> productSaveResultList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            ProductSaveResult productSaveResult = new ProductSaveResult(product.name, product.category, product.price);
            productSaveResultList.add(productSaveResult);
        }

        return productSaveResultList;
    }

    // stream
    public List<ProductSaveResult> saveList2(List<Product> products) {
        return products
                .stream()
                .map(product -> new ProductSaveResult(product.name, product.category, product.price))
                .collect(Collectors.toList());
    }

}
