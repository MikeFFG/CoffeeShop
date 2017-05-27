package com.cs665.customerProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * Proxy class that receives the getProfile call and makes the determination
 * whether to use the local cache or whether to make the expensive call.
 * Ideally, this would be used to save favorite drinks, give discounts, etc.
 * Created by mburke on 5/23/17.
 */
public class ProfileManagerProxy extends ProfileManager {
    private List<Profile> list = new ArrayList<>();
    private ProfileManager profileManagerExpensive = ProfileManagerExpensive.getProfileManagerSingleton();
    private static ProfileManagerProxy profileManagerProxy = new ProfileManagerProxy();

    // Initialize with some dummy data for testing
     {
        list.add(new Profile(0, "Michael Burke",null));
        list.add(new Profile(1, "Dennis Burke",null));
        list.add(new Profile(2, "Jessica Burke", null));
        list.add(new Profile(3,"David Burke", null));
     }

    private ProfileManagerProxy() {}

    public static ProfileManager getProfileManagerSingleton() {
        return profileManagerProxy;
    }

    /**
     * Decides whether or not to make the expensive call or to return from local cache
     * Precondition: we assume the customerID is valid and that a user would not enter
     * an ID that does not exist. Obviously, in a real program we would need to check thoroughly.
     * @param customerID - id to look up
     * @return - the selected profile
     */
    @Override
    public Profile getProfile(int customerID) {
        Profile profile = null;
        for (Profile p : list) {
            if (p.getCustomerID() == customerID) {
                profile = p;
            }
        }
        if (profile == null) {  // Profile is not in the local cache
            profile = profileManagerExpensive.getProfile(customerID);
            this.add(profile);
        }
        return profile;
    }

    // Simple ID generation. Not implementing more sophisticated checks or complexity
    public int generateNewCustomerID() {
        return list.get(list.size() - 1).getCustomerID() + 1;
    }
}
