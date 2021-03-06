package com.lech.bartlomiej;


import com.lech.bartlomiej.devices.*;
import com.lech.bartlomiej.infrastructure.InMemoryProductRepository;
import com.lech.bartlomiej.infrastructure.ScanService;
import com.lech.bartlomiej.model.*;


public class Application {

    private static final String EXIT = "exit";

    private static OutputDevice lcdDevice;
    private static OutputDevice printer;
    private static InputDevice barCodeScanner;

    private static ScanService scanService;
    private static Receipt receipt;

    public static void main(String[] args) {

        init();

        while (true) {
            String inputBarCode = barCodeScanner.scan();

            if (inputBarCode.isEmpty()) {
                lcdDevice.print(Statement.INVALID_BAR_CODE.name());
                continue;
            } else if (inputBarCode.equals(EXIT)) {
                Money totalSum = receipt.calculateTotalSum();
                receipt.addTotalSum(totalSum);
                printReceipt(receipt);
                printOnScreen(totalSum);
                receipt = new Receipt();
                continue;
            }
            ReceiptLine receiptLine = scanService.scanBarCode(inputBarCode);
            receipt.addReceiptLine(receiptLine);
            lcdDevice.print(receiptLine);
        }
    }

    private static void printOnScreen(Money totalSum) {
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
        scanService = new ScanService(productRepository);
        receipt = new Receipt();
    }

}
