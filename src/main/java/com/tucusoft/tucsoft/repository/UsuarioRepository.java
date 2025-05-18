package com.tucusoft.tucsoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tucusoft.tucsoft.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByEmail(String email);     // Buscar por email
    Optional<Usuario> findByNombre(String nombre);   // Buscar por nombre
}
