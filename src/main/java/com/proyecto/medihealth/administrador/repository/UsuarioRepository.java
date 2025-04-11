package com.proyecto.medihealth.administrador.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.medihealth.administrador.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}
