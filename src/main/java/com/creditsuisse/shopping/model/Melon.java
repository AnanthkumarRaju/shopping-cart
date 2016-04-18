package com.creditsuisse.shopping.model;


import static com.creditsuisse.shopping.model.OfferType.BUY_ONE_GET_ONE_FREE;

public class Melon extends Product<Melon> {
    private static final double UNIT_PRICE = 0.50;
    private static final OfferType OFFER = BUY_ONE_GET_ONE_FREE;

    public static Melon newInstance() {
        return new Melon();
    }

    public Melon() {
        super(UNIT_PRICE, OFFER);
    }
}
