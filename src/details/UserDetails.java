package details;

import enums.Roles;

public interface UserDetails {
    Roles getAuthorities();

    String getPassword();


    String getUsername();


    boolean isAccountNonExpired();


    boolean isAccountNonLocked();


    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
