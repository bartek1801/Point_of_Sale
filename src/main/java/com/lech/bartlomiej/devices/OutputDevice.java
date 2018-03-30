package com.lech.bartlomiej.devices;


import com.lech.bartlomiej.model.ReceiptLine;

public interface OutputDevice {

    void print(ReceiptLine receiptLine);

    default void print(String message) {
        System.out.println(message);
    }
}
