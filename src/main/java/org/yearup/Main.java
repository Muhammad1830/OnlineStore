package org.yearup;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        store.loadInventory("Inventory.csv");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    store.showProducts();
                    System.out.print("Enter product ID to add to cart or X to return to menu: ");
                    String productId = scanner.nextLine();
                    if (!productId.equalsIgnoreCase("X")) {
                        store.addToCart(productId);
                    }
                    break;
                case 2:
                    store.showCart();
                    System.out.print("Enter C to check out or X to return to menu: ");
                    String cartAction = scanner.nextLine();
                    if (cartAction.equalsIgnoreCase("C")) {
                        System.out.print("Enter payment amount: ");
                        double payment = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline character
                        store.checkOut(payment);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}