package com.creditsuisse.shopping.model.function;

import com.creditsuisse.shopping.model.Apple;
import com.creditsuisse.shopping.model.Banana;
import com.creditsuisse.shopping.model.Lime;
import com.creditsuisse.shopping.model.Melon;
import org.junit.Test;

import static com.creditsuisse.shopping.model.function.PriceByProduct.PRICE_BY_PRODUCT;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PriceByProductTest {

    @Test
    public void testApply_ProductPrices() throws Exception {
        assertThat(round(PRICE_BY_PRODUCT.apply(Apple.newInstance().setQuantity(3))), is(1.05));
        assertThat(round(PRICE_BY_PRODUCT.apply(Banana.newInstance().setQuantity(3))), is(0.60));
        assertThat(round(PRICE_BY_PRODUCT.apply(Melon.newInstance().setQuantity(3))), is(1.00));
        assertThat(round(PRICE_BY_PRODUCT.apply(Lime.newInstance().setQuantity(3))), is(0.30));
    }

    private Double round(double price) {
        return Math.round(price * 100.0) / 100.0;
    }
}