package org.yearup;

import java.util.Scanner;

public class Main

{
    public static void main(String[] args)

    {
        boolean continueApp = true;

        while (continueApp)
        {
            OnlineStore store = new OnlineStore();
            store.loadInventory("Inventory.csv");
            Scanner scanner = new Scanner(System.in);

            boolean exit = false;

            while (!exit)
            {
                System.out.println("\nMenu:");
                System.out.println("1. Show Products");
                System.out.println("2. Show Cart");
                System.out.println("3. Exit");
                System.out.print("Enter your choice (1/2/3): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice)
                {
                    case 1:
                        store.showProducts();
                        System.out.print("Enter product ID to add to cart or X to return to menu: ");
                        String productId = scanner.nextLine().toUpperCase();

                        if (!productId.equalsIgnoreCase("X"))
                        {
                            store.addToCart(productId);
                        }


                        break;
                    case 2:
                        store.showCart();
                        System.out.print("Enter C to check out or X to return to menu: ");
                        String cartAction = scanner.nextLine().toUpperCase();

                        if (cartAction.equalsIgnoreCase("C"))
                        {
                            System.out.print("Enter payment amount: ");
                            double payment = scanner.nextDouble();
                            scanner.nextLine();
                            store.checkOut(payment);
                        }


                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        System.out.print("Press R to restart the application: ");
                        String restart = scanner.nextLine().toUpperCase();

                        if (!restart.equalsIgnoreCase("R"))
                        {
                            exit = true;
                            continueApp = false;
                        }


                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}