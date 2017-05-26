package com.cs665.customerProfile;

import java.util.List;

/**
 * Created by mburke on 5/24/17.
 */
public abstract class ProfileManager {
    private List<Profile> list;

    protected ProfileManager() {}

    public abstract Profile getProfile(int customerID);

    public abstract int generateNewCustomerID();

    public void add(Profile profile) {
        list.add(profile);
    }

}
