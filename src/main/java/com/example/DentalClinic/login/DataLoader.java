package com.example.DentalClinic.login;

import com.example.DentalClinic.login.User;
import com.example.DentalClinic.login.UserRole;
import com.example.DentalClinic.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args)  {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");


        userRepository.save(new User("Admin", "admin", "admin@gmail.com", hashedPassword, UserRole.ADMIN));
        userRepository.save(new User("User", "user", "user@gmail.com", hashedPassword2, UserRole.USER));
    }
}
