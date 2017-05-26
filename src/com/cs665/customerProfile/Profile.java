package com.cs665.customerProfile;

import com.cs665.coffeeshop.DrinkComponent;

/**
 * Created by mburke on 5/23/17.
 */
public class Profile {
    private int customerID;
    private String customerName;
    private DrinkComponent favoriteMenuItem;

    public Profile(int customerID, String customerName, DrinkComponent favoriteMenuItem) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.favoriteMenuItem = favoriteMenuItem;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public DrinkComponent getFavoriteMenuItem() {
        return favoriteMenuItem;
    }

    public void setFavoriteMenuItem(DrinkComponent favoriteMenuItem) {
        this.favoriteMenuItem = favoriteMenuItem;
    }
}
