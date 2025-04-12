package com.proyecto.medihealth.administrador.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.medihealth.common.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}