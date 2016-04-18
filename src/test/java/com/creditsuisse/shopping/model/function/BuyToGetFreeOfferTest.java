package com.creditsuisse.shopping.model.function;

import org.junit.Test;

import static com.creditsuisse.shopping.model.Apple.newInstance;
import static com.creditsuisse.shopping.model.function.BuyToGetFreeOffer.BUY_ONE_GET_ONE_FREE_OFFER;
import static com.creditsuisse.shopping.model.function.BuyToGetFreeOffer.BUY_THREE_FOR_THE_PRICE_OF_TWO_OFFER;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BuyToGetFreeOfferTest {

    @Test
    public void testApply_BuyOneGetOneFreeOffer() throws Exception {
        assertThat(BUY_ONE_GET_ONE_FREE_OFFER.apply(newInstance().setQuantity(1)), is(0.35));
        assertThat(BUY_ONE_GET_ONE_FREE_OFFER.apply(newInstance().setQuantity(2)), is(0.35));
        assertThat(BUY_ONE_GET_ONE_FREE_OFFER.apply(newInstance().setQuantity(3)), is(0.70));
        assertThat(BUY_ONE_GET_ONE_FREE_OFFER.apply(newInstance().setQuantity(4)), is(0.70));
    }

    @Test
    public void testApply_BuyThreeForThePriceOfTwo() throws Exception {
        assertThat(BUY_THREE_FOR_THE_PRICE_OF_TWO_OFFER.apply(newInstance().setQuantity(1)), is(0.35));
        assertThat(BUY_THREE_FOR_THE_PRICE_OF_TWO_OFFER.apply(newInstance().setQuantity(2)), is(0.70));
        assertThat(BUY_THREE_FOR_THE_PRICE_OF_TWO_OFFER.apply(newInstance().setQuantity(3)), is(0.70));
    }
}