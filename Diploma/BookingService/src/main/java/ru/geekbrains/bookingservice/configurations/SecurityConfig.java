package ru.geekbrains.bookingservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.geekbrains.bookingservice.services.MyUserDetailsService;

import static ru.geekbrains.bookingservice.model.enums.RoleType.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/index", "/images/**").permitAll()
                        .requestMatchers("/employees", "/branches", "/operations").permitAll()
                        .requestMatchers("/reservations/**").hasAuthority(CLIENT.toString())
                        .requestMatchers("/client/**").hasAuthority(CLIENT.toString())
                        .requestMatchers("/manager/**").hasAuthority(MANAGER.toString())
                        .requestMatchers("/admin/**").hasAuthority(ADMIN.toString())
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/"));
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // TODO
        // return new BCryptPasswordEncoder(8);
        // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8);
        // String hashedAdmin = passwordEncoder.encode("admin");
        // String hashedPassword = passwordEncoder.encode("password");
    }
}
