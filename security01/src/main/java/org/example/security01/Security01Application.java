package org.example.security01;

import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.RequestContextFilter;

import java.util.Map;

@SpringBootApplication
public class Security01Application implements CommandLineRunner {
    @Autowired
    private ServletContext servletContext;

    public static void main(String[] args) {
        SpringApplication.run(Security01Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Map<String, ? extends FilterRegistration> filters = servletContext.getFilterRegistrations();
        filters.forEach((name, registration) -> {
            System.out.println("Filter name: " + name);
        });

    }
}
