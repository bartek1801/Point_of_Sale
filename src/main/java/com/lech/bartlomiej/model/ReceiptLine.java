package com.lech.bartlomiej.model;


public class ReceiptLine {

    private String name;
    private Money amount;

    public ReceiptLine(Product product) {
        this.name = product.getName();
        this.amount = product.getPrice();
    }

    public ReceiptLine(String name, Money amount) {
        this.name = name;
        this.amount = amount;
    }

    public ReceiptLine(Statement productNotFound) {
        this.name = productNotFound.name();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        if (amount != null)
            return name + " ---> " + amount;
        else
            return name;
    }
}
