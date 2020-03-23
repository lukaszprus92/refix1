package com.company.model;

import java.time.LocalDate;

public class Order {

    private Customer customer;
    private Basket basket;
    private LocalDate orderDate;
    private boolean isPaid;

    public Order(Customer customer, Basket basket, LocalDate orderDate, boolean isPaid) {
        this.customer = customer;
        this.basket = basket;
        this.orderDate = orderDate;
        this.isPaid = isPaid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "\n" + basket + orderDate + isPaid;
    }
    /*public String toString() {
        return "Order{\n" +
                "customer=" + customer +
                ",\nbasket=" + basket +
                ",\norderDate=" + orderDate +
                ",\nisPaid=" + isPaid +
                '}';
    }*/

}
