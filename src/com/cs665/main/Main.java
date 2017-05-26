package com.cs665.main;

import java.util.Scanner;

import com.cs665.coffeeshop.CoffeeShopFacade;
import com.cs665.coffeeshop.Drink;
import com.cs665.coffeeshop.DrinkComponent;
import com.cs665.customerProfile.Profile;
import com.cs665.customerProfile.ProfileManager;
import com.cs665.customerProfile.ProfileManagerProxy;

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

        Profile customer = getCustomerProfile();    // Uses proxy

        // Uses decorator
        DrinkComponent myDrink = getCustomerDrinkChoice();

        System.out.println("Here is our extras menu. " +
                "Type the corresponding number to add to your drink. Type 0 to finish order.");
        boolean keepGoing = true;
        while (keepGoing) {
            coffeeShopFacade.printExtrasMenu();
            int extraChoice = sc.nextInt();
            if (extraChoice == 0) { break; }
            myDrink = getCustomerExtraChoice(myDrink, extraChoice);
        }

        System.out.println("Your drink costs: ");
        System.out.format("$%.2f%n", myDrink.getPrice());
    }

    private static Drink getCustomerDrinkChoice() {
        System.out.println("Here is our base drinks menu. Type the corresponding number to start an Order.");
        coffeeShopFacade.printDrinkMenu();
        int drinkChoice = sc.nextInt();
        if (drinkChoice == 1) {
            return CoffeeShopFacade.createLargeCoffee();
        } else if (drinkChoice == 2) {
            return CoffeeShopFacade.createSmallCoffee();
        } else {
            throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static DrinkComponent getCustomerExtraChoice(DrinkComponent drink, int choice) {
        switch (choice) {
            case 1:
                return CoffeeShopFacade.addExtraShot(drink);
            case 2:
                return CoffeeShopFacade.addSkimMilk(drink);
            case 3:
                return CoffeeShopFacade.addSoyMilk(drink);
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
        return new Profile(profileManagerProxy.generateNewCustomerID(), name, null);
    }
}
