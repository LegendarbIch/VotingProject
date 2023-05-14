package controller;

import model.User;
import model.repository.UsersRepository;

public class RegistrationController {

    private final UsersRepository repository;

    public RegistrationController(UsersRepository usersRepository) {
        this.repository = usersRepository;
    }

    public boolean registerUser(User user) {
        repository.save(user);
        return true;
    }
}
