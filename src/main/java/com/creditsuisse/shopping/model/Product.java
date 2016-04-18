package com.creditsuisse.shopping.model;

import java.io.Serializable;

public abstract class Product<T> implements Serializable {
    private long quantity;
    private double unitPrice;
    private OfferType offerType;

    public Product(double unitPrice, OfferType offer) {
        this.unitPrice = unitPrice;
        this.offerType = offer;
    }

    public long getQuantity() {
        return quantity;
    }

    public T setQuantity(long quantity) {
        this.quantity = quantity;
        return (T) this;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public OfferType getOfferType() {
        return offerType;
    }

}
