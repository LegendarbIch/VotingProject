package model.repository;

import model.User;
import java.util.HashSet;
import java.util.Set;

public class Storage {
    private static Storage instance;

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    private Storage() {
        this.users = new HashSet<>();
    }
    Set<User> users;

    private void init() {

    }

}
