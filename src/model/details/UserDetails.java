package model.details;

import model.Roles;

import java.util.Collection;

public interface UserDetails {
    Roles getAuthorities();

    String getPassword();


    String getUsername();


    boolean isAccountNonExpired();


    boolean isAccountNonLocked();


    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
