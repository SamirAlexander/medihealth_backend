package com.proyecto.medihealth.administrador.repositories;
import com.proyecto.medihealth.common.models.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.medihealth.common.models.Usuario;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByDocumentoIdentidad(String documentoIdentidad);
}