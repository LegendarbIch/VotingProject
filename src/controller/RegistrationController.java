package controller;

import entity.User;
import repository.UsersRepository;

public class RegistrationController {

    private final UsersRepository repository;

    public RegistrationController(UsersRepository usersRepository) {
        this.repository = usersRepository;
    }

    public void registerUser(User user) {
        repository.save(user);
    }
}
