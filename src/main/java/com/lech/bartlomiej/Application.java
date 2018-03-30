package com.lech.bartlomiej;


import com.lech.bartlomiej.devices.*;
import com.lech.bartlomiej.infrastructure.InMemoryProductRepository;
import com.lech.bartlomiej.infrastructure.ProductService;
import com.lech.bartlomiej.model.*;

import java.math.BigDecimal;
import java.util.Optional;

public class Application {

    private static final String EXIT = "exit";

    private static OutputDevice lcdDevice;
    private static OutputDevice printer;
    private static InputDevice barCodeScanner;

    private static ProductService productService;

    public static void main(String[] args) {

        init();
        Receipt receipt = new Receipt();

        while (true) {
            lcdDevice.print(Statement.SCAN_YOUR_PRODUCT.name());
            String inputValue = barCodeScanner.scan();

            if (inputValue.isEmpty()) {
                lcdDevice.print(Statement.INVALID_BAR_CODE.name());
                continue;
            }

            Optional<Product> optionalProduct = productService.scanProduct(inputValue);

            if (optionalProduct.isPresent()) {
                receipt.addReceiptLine(optionalProduct.get());
                lcdDevice.print(new ReceiptLine(optionalProduct.get())); // może niech drukuje ReceiptLine ???
            } else if (!inputValue.equals(EXIT))
                lcdDevice.print(Statement.PRODUCT_NOT_FOUND.name());

            if (inputValue.equals(EXIT)) {
                BigDecimal totalSum = receipt.calculateTotalSum();
                receipt.addTotalSum(totalSum);
                printReceipt(receipt);
                printOnScreen(totalSum);
                receipt = new Receipt();
            }
        }
    }

    private static void printOnScreen(BigDecimal totalSum) {
        lcdDevice.print(new ReceiptLine("Total Sum", totalSum));
    }

    private static void printReceipt(Receipt receipt) {
        receipt.getReceiptLines().forEach(receiptLine -> printer.print(receiptLine));
    }


    private static void init() {
        lcdDevice = new LCDDevice();
        printer = new PrinterDevice();
        barCodeScanner = new BarCodeScanner();
        ProductRepository productRepository = new InMemoryProductRepository();
        productService = new ProductService(productRepository);
    }

}
