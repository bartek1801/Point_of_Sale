package com.lech.bartlomiej.devices;


import com.lech.bartlomiej.model.ReceiptLine;


public class LCDDevice implements OutputDevice {
    @Override
    public void print(ReceiptLine receiptLine) {
        System.out.println("LCD: " + receiptLine.toString());
    }

    @Override
    public void print(String message) {
        System.out.println("LCD: " + message);
    }


}