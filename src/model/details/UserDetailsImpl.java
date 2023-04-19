package model.details;

import model.Roles;
import model.User;

public class UserDetailsImpl implements UserDetails {
    private User user;

    UserDetailsImpl(User user){
        this.user = user;
    }
    @Override
    public Roles getAuthorities() {
        return user.getRole();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getFIO();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
