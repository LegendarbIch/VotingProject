package controller;

import model.User;

import java.time.LocalDate;

public class DataEntry {
    private final RegistrationForUser registrationForUser;
    private final LoginForUser loginForUser;

    private


    public DataEntry(RegistrationForUser registration, LoginForUser login){
        this.registrationForUser = registration;
        this.loginForUser = login;
    }

    public void registration() {
        String FIO = InputController.write();
        String password = InputController.write();
        LocalDate dateOfBirth = LocalDate.parse(InputController.write());
        registrationForUser.register(new User(FIO, dateOfBirth, password));
    }
}
