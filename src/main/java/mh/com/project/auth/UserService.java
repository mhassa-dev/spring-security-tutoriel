package mh.com.project.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by mh on 23/08/2020.
 */
@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("fake") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));
    }
}
