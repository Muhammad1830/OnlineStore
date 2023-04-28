package org.yearup;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;
    private double totalAmount;

    public Cart() {
        products = new ArrayList<>();
        totalAmount = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
    }

    public void clear() {
        products.clear();
        totalAmount = 0;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}