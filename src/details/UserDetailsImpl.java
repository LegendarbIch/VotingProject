package details;

import enums.Roles;
import entity.User;
import repository.UsersRepository;

import java.util.Optional;

public class UserDetailsImpl implements UserDetails {
    private final User user;
    private final UsersRepository usersRepository = new UsersRepository();

    public UserDetailsImpl(User user){
        this.user = user;
    }
    @Override
    public Roles getAuthorities() {
        Optional<User> loginedUser = usersRepository.find(user);
        if (loginedUser.isPresent()) {
            return loginedUser.get().getRole();
        }
        return Roles.USER;
    }

    public boolean isAuthorized = false;
    public boolean isVoted = false;

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
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
