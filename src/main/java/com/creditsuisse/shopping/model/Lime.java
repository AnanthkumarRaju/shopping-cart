package com.creditsuisse.shopping.model;

public class Lime extends Product<Lime> {
    private static final double UNIT_PRICE = 0.15;
    private static final OfferType OFFER = OfferType.BUY_THREE_FOR_THE_PRICE_OF_TWO;

    public static Lime newInstance() {
        return new Lime();
    }

    public Lime() {
        super(UNIT_PRICE, OFFER);
    }
}
