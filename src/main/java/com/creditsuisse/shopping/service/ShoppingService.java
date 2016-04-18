package com.creditsuisse.shopping.service;

import com.creditsuisse.shopping.model.Product;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.creditsuisse.shopping.model.function.PriceByProduct.PRICE_BY_PRODUCT;
import static java.text.NumberFormat.getCurrencyInstance;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.groupingBy;

public class ShoppingService {
    private List<Product> productList = emptyList();
    private ProductStore productStore = new ProductStore();

    public ShoppingService(String[] shoppingList) {
        Map<String, Long> itemsWithQuantity = groupShoppingListByItemsAndQuantity(shoppingList);
        productList = populateProductListFrom(itemsWithQuantity);
    }

    public double getTotalPrice() {
        return round(productList.stream().mapToDouble(PRICE_BY_PRODUCT::apply).sum());
    }

    public String getTotalPriceInCurrencyFormat() {
        return getCurrencyInstance(new Locale("en", "GB")).format(getTotalPrice());
    }

    private Map<String, Long> groupShoppingListByItemsAndQuantity(String[] items) {
        return asList(items).stream().collect(groupingBy(Function.<String>identity(), Collectors.<String>counting()));
    }

    private List<Product> populateProductListFrom(Map<String, Long> itemsWithQuantity) {
        try {
            return itemsWithQuantity.entrySet().stream().map(itemWithQuantity -> {
                Product product = productStore.findProductByName(itemWithQuantity.getKey());
                product.setQuantity(itemWithQuantity.getValue());
                return product;
            }).collect(Collectors.<Product>toList());
        } catch (Exception e) {
            throw new RuntimeException("Invalid product found in the cart");
        }
    }

    private Double round(double price) {
        return Math.round(price * 100.0) / 100.0;
    }
}
