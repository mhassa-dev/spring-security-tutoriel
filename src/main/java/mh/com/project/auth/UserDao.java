package mh.com.project.auth;

import java.util.Optional;

/**
 * Created by mh on 23/08/2020.
 */
public interface UserDao {
    Optional<User> findByUsername(String username);
}
