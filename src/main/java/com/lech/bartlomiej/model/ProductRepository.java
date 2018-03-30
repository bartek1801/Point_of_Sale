package com.lech.bartlomiej.model;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> getByBarcode(String barcode);


}
