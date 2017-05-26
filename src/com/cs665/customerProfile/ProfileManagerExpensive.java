package com.cs665.customerProfile;

/**
 * @author michael.burke
 * @since 5/26/17
 */
public class ProfileManagerExpensive extends ProfileManager {
    private static ProfileManagerExpensive profileManagerExpensive = new ProfileManagerExpensive();

    private ProfileManagerExpensive() {
    }

    public static ProfileManager getProfileManagerSingleton() {
        return profileManagerExpensive;
    }

    @Override
    public Profile getProfile(int customerID) {
        // Simulates an "expensive" call by sleeping
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Just return a fake profile as if there was actually a real API to call
        return new Profile(customerID, "Default Name", null);
    }

    public int generateNewCustomerID() {
        return ProfileManagerProxy.getProfileManagerSingleton().generateNewCustomerID();
    }
}
