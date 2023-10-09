package com.furniture.hms.configuation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigEncodePassword {
    @Bean
    public BCryptPasswordEncoder passwordEnCoder() {
        return new BCryptPasswordEncoder();
    }
}
