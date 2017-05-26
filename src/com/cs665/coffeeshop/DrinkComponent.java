package com.cs665.coffeeshop;

/**
 * Parent abstract class for the Decorator pattern.
 * Created by mburke on 5/23/17.
 */
public abstract class DrinkComponent {
    protected double price;
    protected String name;

    public double getPrice() {
        return price;
    }

    public String getName() { return name; }

    public abstract void display();
}
