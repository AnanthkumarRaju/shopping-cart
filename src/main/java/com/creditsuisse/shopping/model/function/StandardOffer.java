package com.creditsuisse.shopping.model.function;

import com.creditsuisse.shopping.model.Product;

import java.util.function.Function;

public class StandardOffer implements Function<Product, Double> {
    public static final StandardOffer STANDARD_OFFER = new StandardOffer();

    @Override
    public Double apply(Product product) {
        return product.getUnitPrice() * product.getQuantity();
    }
}
