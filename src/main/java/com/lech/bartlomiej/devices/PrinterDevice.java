package com.lech.bartlomiej.devices;


import com.lech.bartlomiej.model.ReceiptLine;

public class PrinterDevice implements OutputDevice {

    @Override
    public void print(ReceiptLine receiptLine) {
        System.out.println("Printer: " + receiptLine.toString());
    }

    @Override
    public void print(String message) {
        System.out.println("Printer: " + message);
    }


}
