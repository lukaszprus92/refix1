package com.company.repository;

import com.company.model.Cloth;
import com.company.model.Food;
import com.company.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public static final List<Product> AVAILABLE_PRODUCTS = getInitialProducts();

    private static List<Product> getInitialProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Cloth("Koszulka Gucci", 1000.55, 36));
        products.add(new Food("Wołowina", 40.05, false));
        products.add(new Cloth("Złote naje", 399.99, 42));
        products.add(new Food("Jabłko", 4.99, true));
        products.add(new Cloth("Bluza Reebok", 507.05, 40));
        products.add(new Food("Kebab", 13.0, false));
        return products;
    }

}
