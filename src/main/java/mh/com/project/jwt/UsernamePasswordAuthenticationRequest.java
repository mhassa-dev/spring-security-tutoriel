package mh.com.project.jwt;

/**
 * Created by mh on 23/08/2020.
 */
public class UsernamePasswordAuthenticationRequest {
    private String username;
    private String password;

    public UsernamePasswordAuthenticationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
