package entity;

import enums.Roles;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID uuid;
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Roles role;
    private String password;

    public User(String name, LocalDate dateOfBirth, String password) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.role = Roles.USER;
        this.password = password;
    }
    public User(String name, LocalDate dateOfBirth, Roles role, String password) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.password = password;
    }
    public User(String name, String password) {
        this.password = password;
        this.name = name;
        this.role = Roles.USER;
    }
    public User(String name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
