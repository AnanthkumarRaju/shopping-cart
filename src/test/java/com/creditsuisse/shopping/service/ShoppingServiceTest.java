package com.creditsuisse.shopping.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingServiceTest {

    private ShoppingService shoppingService;

    @Test
    public void testGetTotalPrice_WhenMixedItemsPlaced() throws Exception {
        shoppingService = new ShoppingService(new String[]{"Apple", "Banana", "Melon", "Lime"});

        assertThat(shoppingService.getTotalPrice(), is(1.20));
    }

    @Test
    public void testGetTotalPrice_WhenMultipleNonOfferItemsPlaced() throws Exception {
        shoppingService = new ShoppingService(new String[]{"Apple", "Apple", "Banana", "Banana", "Banana"});

        assertThat(shoppingService.getTotalPrice(), is(1.30));
    }

    @Test
    public void testGetTotalPrice_WhenMultipleBuyOneGetOneFreeItemsPlaced() throws Exception {
        shoppingService = new ShoppingService(new String[]{"Melon", "Melon", "Melon"});

        assertThat(shoppingService.getTotalPrice(), is(1.0));
    }

    @Test
    public void testGetTotalPrice_WhenMultipleBuyThreeForThePriceOfTwoItemsPlaced() throws Exception {
        shoppingService = new ShoppingService(new String[]{"Lime", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime"});

        assertThat(shoppingService.getTotalPrice(), is(0.75));
    }

    @Test
    public void testGetTotalPrice_WhenMultipleMixedOfferItemsPlaced() throws Exception {
        shoppingService = new ShoppingService(new String[]{"Melon", "Melon", "Melon", "Lime", "Lime", "Lime"});

        assertThat(shoppingService.getTotalPrice(), is(1.30));
    }

    @Test
    public void testGetTotalPrice_WhenMultipleOfferAndNonOfferItemsPlaced() throws Exception {
        shoppingService = new ShoppingService(new String[]{"Banana", "Apple", "Apple", "Melon", "Melon", "Lime", "Lime", "Lime"});

        assertThat(shoppingService.getTotalPrice(), is(1.70));
    }

    @Test(expected = RuntimeException.class)
    public void testGetTotalPrice_WhenInvalidItemsPlaced_ShouldThroughRunTimeException() throws Exception {
        new ShoppingService(new String[]{"Orange"});
    }

    @Test
    public void testGetTotalPrice_WhenSingleItemPlaced() throws Exception {
        assertThat(new ShoppingService(new String[]{"Apple"}).getTotalPrice(), is(0.35));
        assertThat(new ShoppingService(new String[]{"Banana"}).getTotalPrice(), is(0.20));
        assertThat(new ShoppingService(new String[]{"Melon"}).getTotalPrice(), is(0.50));
        assertThat(new ShoppingService(new String[]{"Lime"}).getTotalPrice(), is(0.15));
    }

    @Test
    public void testGetTotalPriceInCurrencyFormat() throws Exception {
        assertThat(new ShoppingService(new String[]{"Apple"}).getTotalPriceInCurrencyFormat(), is("£0.35"));
        assertThat(new ShoppingService(new String[]{"Banana"}).getTotalPriceInCurrencyFormat(), is("£0.20"));
        assertThat(new ShoppingService(new String[]{"Melon"}).getTotalPriceInCurrencyFormat(), is("£0.50"));
        assertThat(new ShoppingService(new String[]{"Lime"}).getTotalPriceInCurrencyFormat(), is("£0.15"));
    }

}