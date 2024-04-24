package dev.jessika.fujimura.AuthenticationSystem.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table
public record Account(
@Id Long id, 
String email, 
String password) {
}

