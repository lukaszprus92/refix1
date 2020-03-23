package com.company;

import com.company.model.*;
import com.company.repository.OrderRepository;
import com.company.repository.ProductRepository;
import com.company.service.ShopService;

import java.time.LocalDate;
import java.util.Scanner;

//import jdk.swing.interop.SwingInterOpUtils;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ShopService shopService = new ShopService();

//        Customer customer = new Customer("Michał", "Strug");
//
//        Basket basket = new Basket(customer);
//
//        Order order = new Order(customer, basket, LocalDate.now(), true);
//
//
//
//
//        System.out.println(shopService.getAvailableProducts());
//        System.out.println("\nPowyżej 1000:");
//        System.out.println(shopService.getAvailableProductsWithPriceGreaterThan(1000.0));
//        System.out.println("\nMiędzy 500 a 1000:");
//        System.out.println(shopService.getAvailableProductsWithPriceBetween(300.0, 1000.0));
//
//
//        // mcp
//
//        System.out.println("\nProdukty w koszyku: ");
//        System.out.println(basket.getProducts());
//
//        int x = 0;
//
//        while(x != 999) {
//            System.out.println("\nKtóry produkt chcesz dodać? 0-5,   aby wyjść wpisz 999");
//            x = scanner.nextInt();
//            if(x != 999){
//            basket.getProducts().add(ProductRepository.AVAILABLE_PRODUCTS.get(x));
//            }
//        }
//
//        shopService.showBasket(basket);
//
//        int y = 0;
//
//        while(y != 999) {
//            System.out.println("\nCzy chcesz usunąć któryś produkt? 0-" + (basket.getProducts().size()-1) + ",   aby wyjść wpisz 999");
//            y = scanner.nextInt();
//            if(y != 999){
//                basket.getProducts().remove(y);
//            }
//        }
//
//        shopService.showBasket(basket);
//
//        System.out.println("\n" + order.toString());
//        // Czemu wyświetla mi order z zapełnionym basketem, chociaż jak tworzyłem order, to basket był pusty?
//
//
//        //teraz add i remove zrobić jako metody



        String loginChoose = "";
        while (!loginChoose.equalsIgnoreCase("x")) {

            loginChoose = showLoginMenu();
            if (loginChoose.equals("1")) {

                String choose = "";
                while (!choose.equalsIgnoreCase("x")) {

                    choose = showAdminMenu();

                    switch (choose) {
                        case "1": {


                            String chooseProductType = "";
                            while (!chooseProductType.equalsIgnoreCase("x")) {

                                chooseProductType = showTypeOfProductsMenu();

                                if (chooseProductType.equals("1")) {
                                    System.out.println("DODAWANIE UBRANIA");
                                    System.out.println("Podaj nazwę: ");
                                    String name = scanner.nextLine();
                                    System.out.println("Podaj rozmiar: ");
                                    int size = scanner.nextInt();
                                    System.out.println("Podaj cenę: ");
                                    double price = scanner.nextDouble();
                                    ProductRepository.AVAILABLE_PRODUCTS.add(new Cloth(name, price, size));
                                    System.out.println("Dodano produkt.");

                                    //System.out.println(shopService.getAvailableProducts());

                                    // bez tego gówna sam pobiera następny scanner i sie coś rozpierdala
                                    String x = scanner.nextLine();
                                } else if (chooseProductType.equals("2")) {
                                    System.out.println("DODAWANIE JEDZENIA");
                                    System.out.println("Podaj nazwę: ");
                                    String name = scanner.nextLine();
                                    System.out.println("Czy jest wege? true/false: ");
                                    boolean isVege = scanner.nextBoolean();
                                    System.out.println("Podaj cenę: ");
                                    double price = scanner.nextDouble();

                                    ProductRepository.AVAILABLE_PRODUCTS.add(new Food(name, price, isVege));
                                    System.out.println("Dodano produkt.");

                                    // System.out.println(shopService.getAvailableProducts());

                                    // bez tego gówna sam pobiera następny scanner i sie coś rozpierdala
                                    scanner.nextLine();
                                } else if (chooseProductType.equalsIgnoreCase("x")) {
                                } else {
                                }
                            }// koniec while chooseProductType
                            break;
                        }
                        case "2": {
                            System.out.println(shopService.getAvailableProducts());
                            break;
                        }
                        case "3": {
                            System.out.println(OrderRepository.ORDERS);
                            break;
                        }
                        default: {
                            break;
                        }

                    }// koniec switch choose
                }// koniec while choose
            }// koniec if 1 login
            else if (loginChoose.equals("2")) {

                System.out.println("Podaj imię: ");
                String name = scanner.nextLine();
                System.out.println("Podaj nazwisko: ");
                String lastName = scanner.nextLine();

                Customer customer = new Customer(name, lastName);
                Basket basket = new Basket(customer);
                Order order = new Order(customer, basket, LocalDate.now(), false);

                String userChoose = "";
                while (!userChoose.equalsIgnoreCase("x")) {

                    userChoose = showUserMenu();
                    switch (userChoose) {
                        case "1": {
                            System.out.println("Dostępne produkty w sklepie:");
                            System.out.println(shopService.getAvailableProducts());
                            break;
                        }
                        case "2": {
                            System.out.println("Podaj przedział cenowy.");
                            System.out.println("Od:");
                            Double priceFrom = scanner.nextDouble();
                            System.out.println("Do:");
                            Double priceTo = scanner.nextDouble();
                            System.out.println("Produkty w cenie między " + priceFrom + " a " + priceTo + ":");
                            System.out.println(shopService.getAvailableProductsWithPriceBetween(priceFrom, priceTo));

                            // znowu bez tego wyświetla podwójne menu
                            scanner.nextLine();
                            break;
                        }
                        case "3": {
                            System.out.println("Dostępne produkty:");
                            System.out.println(shopService.getAvailableProducts());
                            System.out.println("\nKtóry produkt chcesz dodać? Podaj numer od 0");
                            int product = scanner.nextInt();
                            shopService.addToBasket(basket, product);
                            System.out.println("Dodano produkt.");

                            // znowu bez tego wyświetla podwójne menu
                            scanner.nextLine();
                            break;
                        }
                        case "4": {
                            System.out.println("Twój koszyk:");
                            shopService.showBasket(basket);
                            System.out.println("\nKtóry produkt chcesz usunąć? Podaj numer od 0");
                            int product = scanner.nextInt();
                            basket.getProducts().remove(product);
                            System.out.println("Usunięto produkt.");

                            // znowu bez tego wyświetla podwójne menu
                            scanner.nextLine();
                            break;
                        }
                        case "5": {
                            shopService.showBasket(basket);
                            break;
                        }
                        case "6": {

                            order.setPaid(true);
                            OrderRepository.ORDERS.add(order);
                            //basket.getProducts().clear();
                            System.out.println("Zamówiono.");

                            break;
                        }
                    }
                }
            } else if (loginChoose.equals("x")) {
            } else {
                System.out.println("Złe polecenie");
            }
        } // koniec whiile login

    }//koniec maina

    private static String showLoginMenu() {
        System.out.println("\nLOGOWANIE:");
        System.out.println("1. Admin");
        System.out.println("2. Klient");
        System.out.println("X. EXIT");

        return scanner.nextLine();
    }

    private static String showAdminMenu() {
        System.out.println("\nADMIN MENU:");
        System.out.println("1. Dodaj produkt.");
        System.out.println("2. Wyświetl dostępne produkty.");
        System.out.println("3. Wyświetl zamówienia");
        System.out.println("X. LOGOUT");

        return scanner.nextLine();
    }

    private static String showTypeOfProductsMenu() {
        System.out.println("\nWybierz typ produktu, który chcesz dodać:");
        System.out.println("1. Ubrania");
        System.out.println("2. Jedzenie");
        System.out.println("X. Powrót");

        return scanner.nextLine();
    }

    private static String showUserMenu() {
        System.out.println("\nKLIENT MENU:");
        System.out.println("1. Wyświetl dostępne produkty");
        System.out.println("2. Wyświetl produkty w danym przedziale cenowym");
        System.out.println("3. Dodaj do koszyka");
        System.out.println("4. Usuń z koszyka");
        System.out.println("5. Wyświetl swój koszyk");
        System.out.println("6. Zamów");
        System.out.println("X. LOGOUT");

        return scanner.nextLine();
    }


}
