package com.cs665.coffeeshop;

import java.util.ArrayList;

/**
 * Created by mburke on 5/23/17.
 */
public class Order {
    private ArrayList<DrinkComponent> drinks;

    public Order () {}

    public Order (DrinkComponent drink) {
        drinks.add(drink);
    }

    public Order (ArrayList<DrinkComponent> drinks) {
        this.drinks = drinks;
    }

    public ArrayList<DrinkComponent> getDrinks() {
        return drinks;
    }

    public boolean addDrink(DrinkComponent drink) {
        return drinks.add(drink);
    }

    public double getTotal() {
        double total = 0;
        for (DrinkComponent drink : drinks) {
            total += drink.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Your order is: ");
        for (DrinkComponent drink : drinks) {
            System.out.println(drink);
        }
        System.out.println("For a total of: ");
        System.out.println(this.getTotal());
    }

}
