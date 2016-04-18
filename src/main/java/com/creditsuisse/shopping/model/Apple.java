package com.creditsuisse.shopping.model;


import static com.creditsuisse.shopping.model.OfferType.STANDARD_OFFER;

public class Apple extends Product<Apple> {
    private static final double UNIT_PRICE = 0.35;
    private static final OfferType OFFER = STANDARD_OFFER;

    public static Apple newInstance() {
        return new Apple();
    }

    public Apple() {
        super(UNIT_PRICE, OFFER);
    }
}
