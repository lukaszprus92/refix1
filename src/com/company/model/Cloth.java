package com.company.model;

public class Cloth extends Product {

    private int size;

    public Cloth(String name, Double price, int size) {
        super(name, price);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "\nCloth{" +
                "size=" + size +
                ", name='" + name + '\'' +
                ", price=" + price +
                "}";
    }
}
