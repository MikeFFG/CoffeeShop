package com.cs665.customerProfile;

/**
 * Created by mburke on 5/24/17.
 */
public class ProfileManager {
    public static Profile getProfile(int customerID) throws InterruptedException {
        return ProfileProxy.getProfile(customerID);
    }
}
