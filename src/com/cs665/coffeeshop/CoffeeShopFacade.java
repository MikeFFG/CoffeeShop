package com.cs665.coffeeshop;

/**
 * Created by mburke on 5/23/17.
 */
public class CoffeeShopFacade {
    private static CoffeeShopFacade coffeeShopFacadeSingleton = new CoffeeShopFacade();
    private CoffeeShopFacade() {}

    public static CoffeeShopFacade getCoffeeShopFacadeSingleton() {
        return coffeeShopFacadeSingleton;
    }

    public void printDrinkMenu() {
        Menu.printDrinkMenu();
    }

    public void printExtrasMenu() {
        Menu.printExtrasMenu();
    }

    public static Drink createLargeCoffee() {
        return new LargeCoffee();
    }

    public static Drink createSmallCoffee() {
        return new SmallCoffee();
    }

    public static DrinkDecorator addExtraShot(DrinkComponent drink) {
        return new EspressoShot(drink);
    }

    public static DrinkDecorator addSkimMilk(DrinkComponent drink) {
        return new SkimMilk(drink);
    }

    public static DrinkDecorator addSoyMilk(DrinkComponent drink) {
        return new SoyMilk(drink);
    }
}
