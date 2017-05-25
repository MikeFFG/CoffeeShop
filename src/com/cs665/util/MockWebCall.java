package com.cs665.util;

import com.cs665.customerProfile.Profile;

/**
 * Created by mburke on 5/23/17.
 */
public class MockWebCall {
    /* Simulates an 'expensive' call to the web. To do so, adding Thread.sleep to make it slow. */
    public static Profile getProfile(int customerID) throws InterruptedException {
        Thread.sleep(5000);
        return new Profile(customerID, "Default Name", null);
    }
}
