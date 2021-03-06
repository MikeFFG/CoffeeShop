package com.cs665.coffeeshop;

/**
 * Subclass for the Decorator pattern that gets added on to the Drink base.
 * Created by mburke on 5/23/17.
 */
public abstract class DrinkDecorator extends DrinkComponent {
    protected DrinkComponent baseItem;
    protected String name;

    public DrinkDecorator(DrinkComponent itemToDecorate, String name) {
        this.baseItem = itemToDecorate;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return baseItem.getPrice() + price;
    }

    @Override
    public void display() {
        baseItem.display();
        System.out.print("\t + " + name + " - ");
        System.out.format("$%.2f%n", price);
    }
}
