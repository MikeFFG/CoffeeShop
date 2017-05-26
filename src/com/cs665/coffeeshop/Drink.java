package com.cs665.coffeeshop;

/**
 * Created by mburke on 5/23/17.
 */
public abstract class Drink extends DrinkComponent {
    protected String name;

    public Drink (String name) {
        this.name = name;
    }
    @Override
    public void display() {
        System.out.print(name + " - ");
        System.out.format("$%.2f%n", price);
    }
}
