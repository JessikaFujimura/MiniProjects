package dev.jessika.fujimura.AuthenticationSystem.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.annotation.Nonnull;


@Table
public record Account(
@Id Long id, 
@Nonnull String email, 
@Nonnull String password) {
}

