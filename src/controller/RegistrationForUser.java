package controller;

import model.User;
import model.repository.UsersRepository;

public class RegistrationForUser implements RegistrationModule<User> {

    private final UsersRepository repository;

    public RegistrationForUser(UsersRepository usersRepository) {
        this.repository = new UsersRepository();
    }
    @Override
    public void register(User user) {
        repository.save(user);
    }
}
