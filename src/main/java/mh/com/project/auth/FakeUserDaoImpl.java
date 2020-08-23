package mh.com.project.auth;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static mh.com.project.models.Role.STUDENT;

/**
 * Created by mh on 23/08/2020.
 */
@Repository("fake")
public class FakeUserDaoImpl implements UserDao {

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
                        "mhassa",
                        "mhassa",
                        true,
                        true,
                        true,
                        true),
                new User(STUDENT.getGrantedAuthorities(),
                        "mhossa",
                        "mhossa",
                        true,
                        true,
                        true,
                        true),
                new User(STUDENT.getGrantedAuthorities(),
                        "mhissa",
                        "mhissa",
                        true,
                        true,
                        true,
                        true)
        );
    }
}
