package org.yearup;

import java.util.ArrayList;
import java.util.List;

public class Cart

{
    private List<Product> products;
    private double totalAmount;

    public Cart()
    {
        products = new ArrayList<>();
        totalAmount = 0;
    }

    public void addProduct(Product product)
    {
        products.add(product);
        totalAmount += product.getPrice();
    }

    public void clear()
    {
        products.clear();
        totalAmount = 0;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public double getTotalAmount()
    {
        return totalAmount;
    }
}