package storage;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final List<User> premiums = new ArrayList<>();
    private final List<User> heights = new ArrayList<>();
    private final List<User> mediums = new ArrayList<>();
    private final List<User> simplers = new ArrayList<>();

    public void addPremium(User user) {
            premiums.add(user);
    }

    public List<User> getPremiums() {
        return premiums;
    }

    public void addHeights(User user) {
        heights.add(user);
    }

    public List<User> getHeights() {
        return heights;
    }

    public void addMediums(User user) {
            mediums.add(user);
    }

    public List<User> getMediums() {
        return mediums;
    }

    public void addSimple(User user) {
            simplers.add(user);
    }

    public List<User> getSimplers() {
        return simplers;
    }
}
