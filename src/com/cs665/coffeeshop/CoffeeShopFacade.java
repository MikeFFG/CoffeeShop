package com.cs665.coffeeshop;

/**
 * Facade for the coffeeshop package that will be used by the User.
 * Shows off Facade, Singleton and Factory patterns.
 *
 * Created by mburke on 5/23/17.
 */
public class CoffeeShopFacade {
    // Singleton
    private static CoffeeShopFacade coffeeShopFacadeSingleton = new CoffeeShopFacade();

    private CoffeeShopFacade() {}

    public static CoffeeShopFacade getCoffeeShopFacadeSingleton() {
        return coffeeShopFacadeSingleton;
    }

    public Order createNewOrder() { return new OrderImpl(); }

    public Order addDrinkToOrder(Order order, DrinkComponent drink) {
        order.addDrink(drink);
        return order;
    }

    /* Display methods */

    public void printOrder(Order order) {
        order.displayOrder();
    }

    public void printDrinkMenu() {
        Menu.printDrinkMenu();
    }

    public void printExtrasMenu() {
        Menu.printExtrasMenu();
    }

    /* Factory methods */

    public Drink createLargeCoffee() {
        return new LargeCoffee();
    }

    public Drink createSmallCoffee() {
        return new SmallCoffee();
    }

    public DrinkDecorator addExtraShot(DrinkComponent drink) {
        return new EspressoShot(drink);
    }

    public DrinkDecorator addSkimMilk(DrinkComponent drink) {
        return new SkimMilk(drink);
    }

    public DrinkDecorator addSoyMilk(DrinkComponent drink) {
        return new SoyMilk(drink);
    }
}
