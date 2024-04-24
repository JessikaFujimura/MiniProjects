package dev.jessika.fujimura.AuthenticationSystem.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
        .authorizeHttpRequests((request) -> request.requestMatchers("/*")
        .permitAll()
        );
        httpSecurity.csrf().disable();
        httpSecurity.cors().disable();
        return httpSecurity.build();
   }
}
