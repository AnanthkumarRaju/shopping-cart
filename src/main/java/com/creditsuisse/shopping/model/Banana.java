package com.creditsuisse.shopping.model;


import static com.creditsuisse.shopping.model.OfferType.STANDARD_OFFER;

public class Banana extends Product<Banana> {
    private static final double UNIT_PRICE = 0.20;
    private static final OfferType OFFER = STANDARD_OFFER;

    public static Banana newInstance() {
        return new Banana();
    }

    public Banana() {
        super(UNIT_PRICE, OFFER);
    }
}
