package org.yearup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OnlineStore {
    private Map<String, Product> inventory;
    private Cart cart;

    public OnlineStore() {
        inventory = new HashMap<>();
        cart = new Cart();
    }

    public void loadInventory(String inventoryFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inventoryFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                String id = data[0].trim();
                String name = data[1].trim();
                double price = Double.parseDouble(data[2].trim());
                Product product = new Product(id, name, price);
                inventory.put(id, product);
            }
        } catch (IOException e) {
            System.err.println("Error reading inventory file: " + e.getMessage());
        }
    }

    public void showProducts() {
        System.out.println("\nProducts:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public void showCart() {
        System.out.println("\nCart:");
        cart.getProducts().forEach(System.out::println);
        System.out.printf("Total Amount: $%.2f%n", cart.getTotalAmount());
    }

    public void addToCart(String productId) {
        Product product = inventory.get(productId);
        if (product != null) {
            cart.addProduct(product);
            System.out.println("Product added to cart: " + product.getName());
        } else {
            System.out.println("Invalid product ID");
        }
    }

    public void checkOut(double payment) {
        double totalAmount = cart.getTotalAmount();
        if (payment >= totalAmount) {
            double change = payment - totalAmount;
            System.out.printf("Change: $%.2f%n", change);
            System.out.println("Items sold:");
            cart.getProducts().forEach(System.out::println);
            cart.clear();
        } else {
            System.out.println("Insufficient payment. Transaction canceled.");
        }
    }
}