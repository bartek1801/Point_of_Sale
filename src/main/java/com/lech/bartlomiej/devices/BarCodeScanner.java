package com.lech.bartlomiej.devices;

import java.util.Scanner;

public class BarCodeScanner implements InputDevice {

    private  Scanner scanner;

    public BarCodeScanner() {
        this.scanner =  new Scanner(System.in);
    }


    @Override
    public String scan() {
        return scanner.nextLine();
    }
}
