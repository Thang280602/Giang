package com.project.sportstore.config;

import com.project.sportstore.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



/**
 * @author thang
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/admin/**").hasAuthority("Admin")
                        .requestMatchers("/","/register", "/login", "/logon", "/logout", "/user/card/**", "/user/AboutUs/**", "/searchCate", "/user/ListingClassic/**", "/user/index2/**", "/user/service/**", "/user/comingup/**", "/user/blog/**", "/user/index/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean
    WebSecurityCustomizer securityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/static/**", "/assetsuser/**", "/assets/**","/uploads/**");
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
