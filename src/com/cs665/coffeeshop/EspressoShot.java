package com.cs665.coffeeshop;

/**
 * Created by mburke on 5/24/17.
 */
public class EspressoShot extends DrinkDecorator {
    public EspressoShot(DrinkComponent itemToDecorate) {
        super(itemToDecorate, "Espresso Shot");
        price = 1.25;
    }


}
