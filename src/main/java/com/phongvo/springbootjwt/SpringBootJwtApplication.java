package com.phongvo.springbootjwt;

import com.phongvo.springbootjwt.models.Account;
import com.phongvo.springbootjwt.models.Role;
import com.phongvo.springbootjwt.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AccountService accountService) {
        return args -> {
            accountService.saveRole((new Role(null, "ROLE_USER")));
            accountService.saveRole((new Role(null, "ROLE_MANAGER")));
            accountService.saveRole((new Role(null, "ROLE_ADMIN")));
            accountService.saveRole((new Role(null, "ROLE_SUPER_ADMIN")));

            accountService.saveAccount(new Account(null, "Phong Vo", "phong", "1234", new ArrayList<>()));
            accountService.saveAccount(new Account(null, "Turing", "turing", "1234", new ArrayList<>()));
            accountService.saveAccount(new Account(null, "Nicholas Cage", "nicholas", "1234", new ArrayList<>()));
            accountService.saveAccount(new Account(null, "Mark Wahlberg", "mark", "1234", new ArrayList<>()));

            accountService.addRoleToAccount("phong", "ROLE_SUPER_ADMIN");
            accountService.addRoleToAccount("turing", "ROLE_ADMIN");
            accountService.addRoleToAccount("nicholas", "ROLE_ADMIN");
            accountService.addRoleToAccount("nicholas", "ROLE_MANAGER");
            accountService.addRoleToAccount("mark", "ROLE_USER");
            accountService.addRoleToAccount("mark", "ROLE_MANAGER");
            accountService.addRoleToAccount("mark", "ROLE_ADMIN");
        };
    }

}
