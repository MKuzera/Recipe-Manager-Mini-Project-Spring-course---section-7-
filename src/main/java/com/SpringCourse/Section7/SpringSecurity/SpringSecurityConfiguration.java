package com.SpringCourse.Section7.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
    @Bean
    public InMemoryUserDetailsManager createInMemoryUserDetailsManager(){
        UserDetails userDetails1 = createNewUserDetails("mati","123");
        UserDetails userDetails2 = createNewUserDetails("me","123");

        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private UserDetails createNewUserDetails(String login, String password) {
        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(login).password(password).roles("USER", "ADMIN").build();
        return userDetails;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        http.formLogin(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.headers(header -> header.frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
