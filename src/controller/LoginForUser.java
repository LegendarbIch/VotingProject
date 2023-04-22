package controller;

import model.User;
import model.repository.UsersRepository;

import java.util.function.Function;
import java.util.function.Predicate;

public class LoginForUser implements LoginModule{

    private final UsersRepository repository;
    private final String password;
    private final String username;
    public LoginForUser(String password, String username, UsersRepository repository){
        this.password = password;
        this.username = username;
        this.repository = new UsersRepository();
    }
    @Override
    public boolean login() {
        for (User user: repository.list()) {

        }
        if (repository.list().stream().filter((Predicate<User>) user -> {
            if (password.equals(user.getPassword()) && username.equals(user.getFIO())){
                return true;
            };
            return false;
        }).findFirst()){
           return true;
        }
        return false;
    }
}
