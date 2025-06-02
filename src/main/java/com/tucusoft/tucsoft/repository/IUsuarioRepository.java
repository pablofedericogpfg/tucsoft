package com.tucusoft.tucsoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tucusoft.tucsoft.model.Usuario;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByEmail(String email);     // Buscar por email
    Optional<Usuario> findByNombre(String nombre);   // Buscar por nombre
}
