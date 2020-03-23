package com.company.service;

import com.company.exception.ArgumentAIsGreaterThanBException;
import com.company.model.Basket;
import com.company.model.Customer;
import com.company.model.Order;
import com.company.model.Product;
import com.company.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ShopService implements CustomerService{

    @Override
    public String getCustomerName(Customer customer) {
        return customer.getName();
    }



    public Double calculate(List<Product> products) {
        double result = 0.0;
        for (Product product : products) {
            result = result + product.getPrice();
        }
        return result;
    }

    //sprawdź czy order jest opłacony i zwróć informację że jest opłacony lub nie
    public String checkIfOrderIsPaid(Order order) {
        if (order.isPaid()) {
            return "Zamówienie jest opłacone";
        } else {
            return "Zamówienie nie jest opłacone";
        }
    }

    public List<Product> getAvailableProducts() {
        return ProductRepository.AVAILABLE_PRODUCTS;
    }

    public List<Product> getAvailableProductsWithPriceGreaterThan(Double price) {
        List<Product> filteredList = new ArrayList<>();

        for (Product availableProduct : ProductRepository.AVAILABLE_PRODUCTS) {
            if(availableProduct.getPrice() > price){
                filteredList.add(availableProduct);
            }
        }
        return filteredList;
    }

    public List<Product> getAvailableProductsWithPriceBetween(Double a, Double b) {
        List<Product> filteredList = new ArrayList<>();

        if(a>b){
            throw new ArgumentAIsGreaterThanBException();
        }

        for (Product availableProduct : ProductRepository.AVAILABLE_PRODUCTS) {
            if(availableProduct.getPrice() > a && availableProduct.getPrice() < b){
                filteredList.add(availableProduct);
            }
        }
        return filteredList;
    }


    // opcje usera:

    public void showBasket(Basket basket){
        System.out.println("Aktualne produkty w Twoim koszyku: ");
        System.out.println(basket.getProducts());

        System.out.println("\nCena koszyka:");
        System.out.println(calculate(basket.getProducts()));
    }
    public void addToBasket(Basket basket, int product){
            basket.getProducts().add(ProductRepository.AVAILABLE_PRODUCTS.get(product));
    }

    /*
        TO NAWET DZIAŁA ALE JEST BEZ SENSU CHYBA
    public void addToBasket(int productNumber, Basket basket){
        System.out.println("\nKtóry produkt chcesz dodać? 0-5");
        basket.getProducts().add(ProductRepository.AVAILABLE_PRODUCTS.get(productNumber));
    }

    */



}
