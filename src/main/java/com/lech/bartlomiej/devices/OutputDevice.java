package com.lech.bartlomiej.devices;


import com.lech.bartlomiej.model.ReceiptLine;

public interface OutputDevice {

    void print(ReceiptLine receiptLine);

    void print(String message);
}
