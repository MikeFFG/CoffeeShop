package com.cs665.coffeeshop;

/**
 * Created by mburke on 5/24/17.
 */
public class SoyMilk extends DrinkDecorator {
    public SoyMilk(DrinkComponent itemToDecorate) {
        super(itemToDecorate);
        price = 0.75;
    }
}
