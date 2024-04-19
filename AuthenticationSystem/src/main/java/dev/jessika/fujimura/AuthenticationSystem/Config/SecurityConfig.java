package dev.jessika.fujimura.AuthenticationSystem.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.FilterInvocation;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

   
}
