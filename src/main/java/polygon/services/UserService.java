package polygon.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import polygon.entities.User;
import polygon.repos.Role;
import polygon.repos.UserRepo;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userDB = userRepo.findByUsername(user.getUsername());

        if (userDB != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));

        LocalDateTime now = LocalDateTime.now();
        user.setRegistrationDate(now);

        userRepo.save(user);

        return true;
    }
}
