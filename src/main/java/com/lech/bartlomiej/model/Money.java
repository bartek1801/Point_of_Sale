package com.lech.bartlomiej.model;

public class Money {

    public static final String DEFAULT_CURRENCY = "CREDIT";
    public static final Money ZERO = new Money();

    private Long cents;
    private String currency;

    private Money() {
        this.cents = 0L;
        this.currency = DEFAULT_CURRENCY;
    }

    private Money(Long cents, String currency) {
        this.cents = cents;
        this.currency = currency;
    }

    public static Money valueOf(Integer value) {
        return valueOf(value, DEFAULT_CURRENCY);
    }

    public static Money valueOf(Integer value, String currency) {
        return new Money(value * 100L, currency);
    }

    public static Money valueOf(double value) {
        return new Money((long) (value * 100.0), DEFAULT_CURRENCY);
    }

    public static Money valueOf(double value, String currency) {
        return new Money((long) (value * 100.0), currency);
    }

    public Money add(Money other) {
        return new Money(cents + other.cents, currency);
    }

    @Override
    public String toString() {
        return String.format("%d.%d %s", cents / 100, cents % 100, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (cents != null ? !cents.equals(money.cents) : money.cents != null) return false;
        return currency != null ? currency.equals(money.currency) : money.currency == null;
    }

    @Override
    public int hashCode() {
        int result = cents != null ? cents.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
