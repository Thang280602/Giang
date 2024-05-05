package com.project.sportstore.home;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author thang
 */
public class TestPassWord {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
