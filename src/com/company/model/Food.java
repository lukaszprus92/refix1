package com.company.model;

public class Food extends Product{

    private boolean isVege;

    public Food(String name, Double price, boolean isVege) {
        super(name, price);
        this.isVege = isVege;
    }

    public boolean isVege() {
        return isVege;
    }

    public void setVege(boolean vege) {
        isVege = vege;
    }

    @Override
    public String toString() {
        return "\nFood{" +
                "isVege=" + isVege +
                ", name='" + name + '\'' +
                ", price=" + price +
                "}";
    }
}
