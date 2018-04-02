package com.lech.bartlomiej.infrastructure;

import com.lech.bartlomiej.model.Product;
import com.lech.bartlomiej.model.ProductRepository;
import com.lech.bartlomiej.model.ReceiptLine;
import com.lech.bartlomiej.model.Statement;

import java.util.Optional;

public class ScanService {


    private ProductRepository productRepository;


    public ScanService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ReceiptLine scanBarCode(String barcode) {
        Optional<Product> optionalProduct = productRepository.getByBarcode(barcode);
        return optionalProduct
                .map(ReceiptLine::new)
                .orElse(new ReceiptLine(Statement.PRODUCT_NOT_FOUND));
    }

}
