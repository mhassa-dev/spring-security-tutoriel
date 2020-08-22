package mh.com.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static mh.com.project.models.Role.*;

/**
 * Created by mh on 19/08/2020.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/v1/students/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails student = User.builder()
                .username("mhassa")
                .password(passwordEncoder.encode("mhassa"))
                .roles(STUDENT.name()) // ROLE_STUDENT
                .build();

        UserDetails admin = User.builder()
                .username("mhossa")
                .password(passwordEncoder.encode("mhossa"))
                .roles(ADMIN.name()) // ROLE_ADMIN
                .build();

        UserDetails management = User.builder()
                .username("mhissa")
                .password(passwordEncoder.encode("mhissa"))
                .roles(ADMIN_TRAINEE.name()) // ROLE_ADMIN_TRAINEE
                .build();

        return new InMemoryUserDetailsManager(student, admin, management);
    }
}
