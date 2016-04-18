package com.creditsuisse.shopping.model.function;

import com.creditsuisse.shopping.model.Product;

import java.util.function.Function;

public class BuyToGetFreeOffer implements Function<Product, Double> {

    public static final BuyToGetFreeOffer BUY_ONE_GET_ONE_FREE_OFFER = new BuyToGetFreeOffer(2, 1);
    public static final BuyToGetFreeOffer BUY_THREE_FOR_THE_PRICE_OF_TWO_OFFER = new BuyToGetFreeOffer(3, 2);

    private int numberOfItemsToBuy;
    private int actualNumberOfItemsToPrice;

    private BuyToGetFreeOffer(int numberOfItemsToBuy, int actualNumberOfItemsToPrice) {
        this.numberOfItemsToBuy = numberOfItemsToBuy;
        this.actualNumberOfItemsToPrice = actualNumberOfItemsToPrice;
    }

    @Override
    public Double apply(Product product) {
        return product.getUnitPrice() *
                (Math.floor(product.getQuantity() / numberOfItemsToBuy) *
                        actualNumberOfItemsToPrice + product.getQuantity() % numberOfItemsToBuy);
    }
}
