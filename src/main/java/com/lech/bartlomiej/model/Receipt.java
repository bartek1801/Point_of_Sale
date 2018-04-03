package com.lech.bartlomiej.model;

import java.util.LinkedList;
import java.util.List;

public class Receipt {

    private List<ReceiptLine> receiptLines;

    public Receipt() {
        this.receiptLines = new LinkedList<>();
    }

    public List<ReceiptLine> getReceiptLines() {
        return receiptLines;
    }

    public void setReceiptLines(List<ReceiptLine> receiptLines) {
        this.receiptLines = receiptLines;
    }

    public void addReceiptLine(ReceiptLine receiptLine) {
        if (receiptLine.getAmount() != null)
            this.receiptLines.add(receiptLine);
    }


    public void addTotalSum(Money totalSum) {
        this.receiptLines.add(new ReceiptLine("Total Sum", totalSum));
    }

    public Money calculateTotalSum() {
        return this.receiptLines.stream()
                        .map(ReceiptLine::getAmount)
                        .reduce(Money.ZERO, Money::add);
    }

}
