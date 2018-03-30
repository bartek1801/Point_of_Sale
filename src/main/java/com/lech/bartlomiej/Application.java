package com.lech.bartlomiej;


import com.lech.bartlomiej.infrastructure.InMemoryProductRepository;
import com.lech.bartlomiej.infrastructure.ProductService;
import com.lech.bartlomiej.model.Product;
import com.lech.bartlomiej.model.ProductRepository;
import com.lech.bartlomiej.model.Receipt;
import com.lech.bartlomiej.model.ReceiptLine;
import com.lech.bartlomiej.output.LCDDevice;
import com.lech.bartlomiej.output.OutputDevice;
import com.lech.bartlomiej.output.PrinterDevice;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    private static final String EXIT = "exit";
    private static final String PRODUCT_NOT_FOUND = "Product not found";
    private static final String INVALID_BAR_CODE = "Invalid bar-code";

    private static Scanner scanner = new Scanner(System.in);

    private static OutputDevice lcdDevice = new LCDDevice();
    private static OutputDevice printer = new PrinterDevice();

    private static ProductService productService;

    public static void main(String[] args) {

        init();
        Receipt receipt = new Receipt();

        while (true) {
            System.out.println(">> Scan your product <<");
            String inputValue = scanner.nextLine();

            if (inputValue.isEmpty()) {
                lcdDevice.print(INVALID_BAR_CODE);
                continue;
            }

            Optional<Product> optionalProduct = productService.scanProduct(inputValue);

            if (optionalProduct.isPresent()) {
                receipt.addReceiptLine(optionalProduct.get());
                lcdDevice.print(new ReceiptLine(optionalProduct.get())); // może niech drukuje ReceiptLine ???
            } else if (!inputValue.equals(EXIT))
                lcdDevice.print(PRODUCT_NOT_FOUND);

            if (inputValue.equals(EXIT)) {
                BigDecimal totalSum = receipt.calculateTotalSum();
                receipt.addTotalSum(totalSum);

                receipt.getReceiptLines().forEach(receiptLine -> printer.print(receiptLine));
                lcdDevice.print(new ReceiptLine("Total Sum", totalSum));

                receipt = new Receipt();
            }

        }

    }


    private static void init() {
        ProductRepository productRepository = new InMemoryProductRepository();
        productService = new ProductService(productRepository);
    }

}
