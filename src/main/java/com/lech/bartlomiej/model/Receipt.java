package com.lech.bartlomiej.model;

import java.math.BigDecimal;
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

    public void addReceiptLine(Product product) {
        this.receiptLines.add(new ReceiptLine(product));
    }


    public void addTotalSum(BigDecimal totalSum) {
        this.receiptLines.add(new ReceiptLine("Total Sum", totalSum));
    }

    public BigDecimal calculateTotalSum() {
        return this.receiptLines.stream()
                        .map(ReceiptLine::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
