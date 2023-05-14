package controller;

import controller.DTO.UserDTO;
import model.User;
import model.repository.UsersRepository;

import java.util.function.Predicate;

public class LoginController {

    private final UsersRepository repository;
    public LoginController(UsersRepository usersRepository){
        this.repository = usersRepository;
    }

    public boolean loginUser(UserDTO incomingUser) {
         return repository.list().stream().anyMatch(user ->
                 incomingUser.getPassword().equals(user.getPassword())
                         && incomingUser.getFIO().equals(user.getFIO()));
    }
}
