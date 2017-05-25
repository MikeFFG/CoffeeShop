package com.cs665.coffeeshop;

/**
 * Created by mburke on 5/23/17.
 */
public abstract class DrinkDecorator extends DrinkComponent {
    protected DrinkComponent baseItem;

    public DrinkDecorator(DrinkComponent itemToDecorate) {
        this.baseItem = itemToDecorate;
    }

    @Override
    public double getPrice() {
        return baseItem.getPrice() + price;
    }
}
