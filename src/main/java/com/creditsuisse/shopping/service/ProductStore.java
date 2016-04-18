package com.creditsuisse.shopping.service;

import com.creditsuisse.shopping.model.*;

import java.util.HashMap;
import java.util.Map;

public class ProductStore {

    /**
     * This acts as a database for product information
     */
    private Map<String, Product> productMap = new HashMap<String, Product>() {{
        put("Apple", Apple.newInstance());
        put("Banana", Banana.newInstance());
        put("Melon", Melon.newInstance());
        put("Lime", Lime.newInstance());

    }};

    public Product findProductByName(String name) {
        return productMap.get(name);
    }
}
