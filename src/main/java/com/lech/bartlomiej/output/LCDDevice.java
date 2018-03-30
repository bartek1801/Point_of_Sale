package com.lech.bartlomiej.output;


import com.lech.bartlomiej.model.ReceiptLine;


public class LCDDevice implements OutputDevice {
    @Override
    public void print(ReceiptLine receiptLine) {
        System.out.println("LCD: " + receiptLine.toString());
    }



}