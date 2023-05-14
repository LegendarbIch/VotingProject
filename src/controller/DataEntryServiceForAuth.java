package controller;

import controller.DTO.UserDTO;
import model.User;

import java.time.LocalDate;

public class DataEntryServiceForAuth {
    private final LoginController loginController;
    private final RegistrationController registrationController;
    private final UserDTO userDTO = new UserDTO();
    public DataEntryServiceForAuth(LoginController loginController, RegistrationController registrationController) {
        this.loginController = loginController;
        this.registrationController = registrationController;
    }
    public void passNickname() {
        userDTO.setFIO(InputUtils.write());
    }
    public void passPassword() {
        userDTO.setPassword(InputUtils.write());
    }
    public void passDateOfBirth() {
        userDTO.setDateOfBirth(LocalDate.parse(InputUtils.write()));
    }
    public boolean login() {
        return loginController.loginUser(new UserDTO(userDTO.getFIO(), userDTO.getPassword()));
    }
    public boolean register() {
        return registrationController.registerUser(new User(userDTO.getFIO(), userDTO.getDateOfBirth(), userDTO.getPassword()));
    }
}
