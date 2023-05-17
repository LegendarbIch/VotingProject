package repository;

import entity.User;

import java.time.LocalDate;
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
        init();
    }
    Set<User> users;

    private void init() {
        users.add(new User("Кирилл", LocalDate.parse("2003-09-02"),"123"));
    }

}
