package com.company.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {

    private Customer customer;
    private List<Product> products = new ArrayList<>();

    public Basket(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "" + customer + products;
    }
}
