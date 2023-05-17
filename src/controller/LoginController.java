package controller;

import entity.User;
import repository.UsersRepository;

public class LoginController {

    private final UsersRepository repository;
    public LoginController(UsersRepository usersRepository){
        this.repository = usersRepository;
    }

    public boolean loginUser(User incomingUser) {
        return repository.list().stream().anyMatch(user ->
                incomingUser.getPassword().equals(user.getPassword())
                        && incomingUser.getName().equals(user.getName()));
    }
}
