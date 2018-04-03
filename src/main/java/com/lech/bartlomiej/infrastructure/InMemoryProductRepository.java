package com.lech.bartlomiej.infrastructure;

import com.lech.bartlomiej.model.Money;
import com.lech.bartlomiej.model.Product;
import com.lech.bartlomiej.model.ProductRepository;

import java.util.*;

public class InMemoryProductRepository implements ProductRepository {

    private static final Map<String, Product> REPO = new HashMap<>();

    static {
        Product prod1 = new Product("101", "Radio", Money.valueOf(199.99));
        Product prod2 = new Product("102", "TV", Money.valueOf(4000));
        Product prod3 = new Product("103", "Laptop", Money.valueOf(3500));
        Product prod4 = new Product("104", "Hi-Fi", Money.valueOf(3500));
        REPO.put(prod1.getBarcode(), prod1);
        REPO.put(prod2.getBarcode(), prod2);
        REPO.put(prod3.getBarcode(), prod3);
        REPO.put(prod4.getBarcode(), prod4);
    }

    @Override
    public Optional<Product> getByBarcode(String barcode) {
        if (!REPO.containsKey(barcode))
            return Optional.empty();
        return Optional.of(REPO.get(barcode));
    }
}
