package com.creditsuisse.shopping.model.function;

import com.creditsuisse.shopping.model.Product;

import java.util.function.Function;

import static com.creditsuisse.shopping.model.function.BuyToGetFreeOffer.BUY_ONE_GET_ONE_FREE_OFFER;
import static com.creditsuisse.shopping.model.function.BuyToGetFreeOffer.BUY_THREE_FOR_THE_PRICE_OF_TWO_OFFER;
import static com.creditsuisse.shopping.model.function.StandardOffer.STANDARD_OFFER;

public class PriceByProduct implements Function<Product, Double> {
    public static final PriceByProduct PRICE_BY_PRODUCT = new PriceByProduct();

    @Override
    public Double apply(Product product) {
        switch (product.getOfferType()) {
            case BUY_ONE_GET_ONE_FREE:
                return BUY_ONE_GET_ONE_FREE_OFFER.apply(product);
            case BUY_THREE_FOR_THE_PRICE_OF_TWO:
                return BUY_THREE_FOR_THE_PRICE_OF_TWO_OFFER.apply(product);
            default:
                return STANDARD_OFFER.apply(product);
        }
    }
}
