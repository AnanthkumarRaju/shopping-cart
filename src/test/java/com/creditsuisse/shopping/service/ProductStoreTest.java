package com.creditsuisse.shopping.service;

import com.creditsuisse.shopping.model.Product;
import org.junit.Test;

import static com.creditsuisse.shopping.model.OfferType.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductStoreTest {

    @Test
    public void testFindProductByName_forApple() throws Exception {
        Product apple = new ProductStore().findProductByName("Apple");
        assertThat(apple.getOfferType(), is(STANDARD_OFFER));
        assertThat(apple.getUnitPrice(), is(0.35));
    }

    @Test
    public void testFindProductByName_forBanana() throws Exception {
        Product apple = new ProductStore().findProductByName("Banana");
        assertThat(apple.getOfferType(), is(STANDARD_OFFER));
        assertThat(apple.getUnitPrice(), is(0.20));
    }

    @Test
    public void testFindProductByName_forMelon() throws Exception {
        Product apple = new ProductStore().findProductByName("Melon");
        assertThat(apple.getOfferType(), is(BUY_ONE_GET_ONE_FREE));
        assertThat(apple.getUnitPrice(), is(0.50));
    }

    @Test
    public void testFindProductByName_forLime() throws Exception {
        Product apple = new ProductStore().findProductByName("Lime");
        assertThat(apple.getOfferType(), is(BUY_THREE_FOR_THE_PRICE_OF_TWO));
        assertThat(apple.getUnitPrice(), is(0.15));
    }
    
    @Test
    public void testFindProductByName_WhenNonExistingProductGiven_ShouldReturnNull() throws Exception {
        assertThat(new ProductStore().findProductByName("Orange"), nullValue());
    }
}