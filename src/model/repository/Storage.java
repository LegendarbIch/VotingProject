package model.repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage instance;

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    private Storage() {
        this.users = new ArrayList<>();
    }
    List<User> users;

    private void init() {

    }

}
