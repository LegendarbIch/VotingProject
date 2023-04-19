package model.repository;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsersRepository implements Repository<User, Long> {

    private final List<User> users;

    public UsersRepository(){
        this.users = Storage.getInstance().users;
    }

    @Override
    public void save(User obj) {
        users.add(obj);
    }

    @Override
    public void delete(User obj) {
        users.remove(obj);
    }

    @Override
    public User findById(Long aLong) {
        return users.stream().filter(u -> u.getId().equals(aLong)).findFirst().orElse(null);
    }

    @Override
    public List<User> list() {
        return new ArrayList<>(users);
    }
}
