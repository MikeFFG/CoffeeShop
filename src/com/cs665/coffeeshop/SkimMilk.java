package com.cs665.coffeeshop;

/**
 * Created by mburke on 5/24/17.
 */
public class SkimMilk extends DrinkDecorator {
    public SkimMilk(DrinkComponent itemToDecorate) {
        super(itemToDecorate, "Skim Milk");
        price = 0.50;
    }
}
