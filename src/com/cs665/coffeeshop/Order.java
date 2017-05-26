package com.cs665.coffeeshop;

/**
 * @author michael.burke
 * @since 5/26/17
 */
public abstract class Order {
    public abstract boolean addDrink(DrinkComponent drink);

    public abstract void displayOrder();
}
