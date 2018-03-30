package com.lech.bartlomiej.output;


import com.lech.bartlomiej.model.ReceiptLine;

public class PrinterDevice implements OutputDevice {

    @Override
    public void print(ReceiptLine receiptLine) {
        System.out.println("Printer: " + receiptLine.toString());
    }


}
