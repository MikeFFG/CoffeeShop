package com.cs665.main;

import com.cs665.coffeeshop.CoffeeShopFacade;
import com.cs665.coffeeshop.Drink;
import com.cs665.coffeeshop.DrinkComponent;
import com.cs665.coffeeshop.Order;
import com.cs665.customerProfile.Profile;
import com.cs665.customerProfile.ProfileManager;
import com.cs665.customerProfile.ProfileManagerProxy;

import java.util.Scanner;

/**
 * Created by mburke on 5/23/17.
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    // Singleton/Facade/Factory
    private static CoffeeShopFacade coffeeShopFacade = CoffeeShopFacade.getCoffeeShopFacadeSingleton();
    // Singleton/Proxy
    private static ProfileManager profileManagerProxy = ProfileManagerProxy.getProfileManagerSingleton();

    public static void main(String[] args) {
        System.out.println("Welcome to my Coffee Shop.");

        // Uses proxy
        Profile customer = getCustomerProfile();

        System.out.println("Starting a new order for you.");
        Order order = coffeeShopFacade.createNewOrder();

        while (true) {
            // Uses decorator
            DrinkComponent myDrink = getCustomerDrinkChoice();

            System.out.println("Here is our extras menu. " +
                    "Type the corresponding number to add to your drink. Type 0 to finish drink.");

            while (true) {
                coffeeShopFacade.printExtrasMenu();
                int extraChoice = sc.nextInt();
                if (extraChoice == 0) { break; }
                myDrink = getCustomerExtraChoice(myDrink, extraChoice);
            }

            System.out.println("Your drink costs: ");
            System.out.format("$%.2f%n", myDrink.getPrice());
            coffeeShopFacade.addDrinkToOrder(order, myDrink);

            System.out.println("Would you like to add another drink? 1 for yes, 2 for no.");
            int choice = sc.nextInt();
            if (choice == 1) {
                continue;
            } else if (choice == 2) {
                break;
            } else {
                throw new IllegalArgumentException("Invalid choice");
            }
        }

        coffeeShopFacade.printOrder(order);
        System.out.println("Goodbye!");
    }

    private static Drink getCustomerDrinkChoice() {
        System.out.println("Here is our base drinks menu. Type the corresponding number to start an Order.");
        coffeeShopFacade.printDrinkMenu();
        int drinkChoice = sc.nextInt();
        if (drinkChoice == 1) {
            return coffeeShopFacade.createLargeCoffee();
        } else if (drinkChoice == 2) {
            return coffeeShopFacade.createSmallCoffee();
        } else {
            throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static DrinkComponent getCustomerExtraChoice(DrinkComponent drink, int choice) {
        switch (choice) {
            case 1:
                return coffeeShopFacade.addExtraShot(drink);
            case 2:
                return coffeeShopFacade.addSkimMilk(drink);
            case 3:
                return coffeeShopFacade.addSoyMilk(drink);
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static Profile getCustomerProfile() {
        Profile customer = null;
        System.out.println("Do you have a customer ID? If so, enter it now. If not, type 0.");
        int customerID = sc.nextInt();
        if (customerID != 0) {
            customer = profileManagerProxy.getProfile(customerID);
            if (customer == null) {
                throw new IllegalArgumentException("Invalid customerID.");
            }
            System.out.println("Welcome back " + customer.getCustomerName());
        } else {
            customer = createNewCustomerProfile();
            System.out.println("Your customer ID is: " + customer.getCustomerID());
        }
        return customer;
    }

    private static Profile createNewCustomerProfile() {
        System.out.println("Creating you a new profile.");
        System.out.println("What is your name?");
        String name = sc.next();
        sc.next(); // consume newLine char
        return new Profile(profileManagerProxy.generateNewCustomerID(), name, null);
    }
}
