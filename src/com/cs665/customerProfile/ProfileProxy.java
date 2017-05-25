package com.cs665.customerProfile;

import com.cs665.util.MockDB;
import com.cs665.util.MockWebCall;

/**
 * Created by mburke on 5/23/17.
 */
public class ProfileProxy {
    protected static Profile getProfile(int customerID) throws InterruptedException {
        Profile profile = MockDB.getProfile(customerID);
        if (profile == null) {
            profile = MockWebCall.getProfile(customerID);
            MockDB.add(profile);
        }
        return profile;
    }
}
