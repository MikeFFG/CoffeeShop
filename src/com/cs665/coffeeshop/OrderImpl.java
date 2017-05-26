package com.cs665.coffeeshop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/23/17.
 */
public class OrderImpl extends Order {
    private List<DrinkComponent> drinks = new ArrayList<>();

    public OrderImpl() {}

    public OrderImpl(DrinkComponent drink) {
        drinks.add(drink);
    }

    public OrderImpl(List<DrinkComponent> drinks) {
        this.drinks = drinks;
    }

    public List<DrinkComponent> getDrinks() {
        return drinks;
    }

    @Override
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

    @Override
    public void displayOrder() {
        System.out.println("Your order is:\n");
        for (DrinkComponent drink : drinks) {
            drink.display();
            System.out.println();
        }
        System.out.print("For a total of ");
        System.out.format("$%.2f%n", this.getTotal());

    }
}
