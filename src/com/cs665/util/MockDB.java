package com.cs665.util;

import com.cs665.customerProfile.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mburke on 5/23/17.
 */
public class MockDB {
    private static List<Profile> list = new ArrayList<>();

    // Initialize with some dummy data
    static {
        list.add(new Profile(0, "Michael Burke",null));
        list.add(new Profile(1, "Dennis Burke",null));
        list.add(new Profile(2, "Jessica Burke", null));
        list.add(new Profile(3,"David Burke", null));
    }

    public static Profile getProfile(int customerID) {
        for (Profile profile : list) {
            if (profile.getCustomerID() == customerID) {
                return profile;
            }
        }
        return null;
    }

    public static void add(Profile profile) {
        list.add(profile);
    }

    public static int generateNewCustomerID() {
        return list.get(list.size() - 1).getCustomerID() + 1;
    }
}
