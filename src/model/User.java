package model;

import javax.management.relation.Role;
import java.time.LocalDate;

public class User {
    private Long id = 0L;
    private String FIO;
    private LocalDate dateOfBirth;
    private Roles role;
    private String password;

    public User(String FIO, LocalDate dateOfBirth, String password) {
        this.id++;
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
        this.role = Roles.USER;
        this.password = password;
    }
    public User(String FIO, LocalDate dateOfBirth, Roles role, String password) {
        this.id++;
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.password = password;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

}
