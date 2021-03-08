package storage;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<User> premiums = new ArrayList<>();
    private static final List<User> mediums = new ArrayList<>();
    private static final List<User> simplers = new ArrayList<>();

    public static void addPremium(User user) {
        if (premiums.contains(user)) {
            premiums.set(premiums.indexOf(user), user);
        } else {
            premiums.add(user);
        }
    }

    public static List<User> getPremiums() {
        return premiums;
    }

    public static void addMediums(User user) {
        if (mediums.contains(user)) {
            mediums.set(mediums.indexOf(user), user);
        } else {
            mediums.add(user);
        }
    }

    public static List<User> getMediums() {
        return mediums;
    }

    public static void addSimple(User user) {
        if (simplers.contains(user)) {
            simplers.set(simplers.indexOf(user), user);
        } else {
            simplers.add(user);
        }
    }

    public static List<User> getSimplers() {
        return simplers;
    }
}
