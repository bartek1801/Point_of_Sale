package com.lech.bartlomiej.infrastructure;

import com.lech.bartlomiej.model.Product;
import com.lech.bartlomiej.model.ProductRepository;

import java.util.Optional;

public class ProductService {


    private ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> scanProduct(String barcode) {
        return productRepository.getByBarcode(barcode);
    }

}
