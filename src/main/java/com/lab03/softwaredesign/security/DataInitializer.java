package com.lab03.softwaredesign.security;

import com.lab03.softwaredesign.user.User;
import com.lab03.softwaredesign.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initializeAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setNombre("Administrador");
                admin.setEmail("admin@lab03.local");
                admin.setRol("admin");
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                userRepository.save(admin);
            }
        };
    }
}