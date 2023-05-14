package controller.DTO;

import model.User;

import java.time.LocalDate;

public class UserDTO {
    public UserDTO(String FIO, String password) {
        this.FIO = FIO;
        this.password = password;
    }
    public UserDTO() {}

    private String FIO;
    private String password;

    private LocalDate dateOfBirth;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
