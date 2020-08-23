package mh.com.project.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static mh.com.project.models.Role.*;

/**
 * Created by mh on 23/08/2020.
 */
@Repository("fake")
public class FakeUserDaoImpl implements UserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return getUsers()
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }

    private List<User> getUsers() {
        return Lists.newArrayList(
                new User(STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode("mhassa"),
                        "mhassa",
                        true,
                        true,
                        true,
                        true),
                new User(ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("mhossa"),
                        "mhossa",
                        true,
                        true,
                        true,
                        true),
                new User(ADMIN_TRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("mhissa"),
                        "mhissa",
                        true,
                        true,
                        true,
                        true)
        );
    }
}
