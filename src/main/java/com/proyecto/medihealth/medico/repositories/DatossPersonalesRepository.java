package com.proyecto.medihealth.medico.repositories;

import com.proyecto.medihealth.common.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DatossPersonalesRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByDocumentoIdentidadAndRol(String documentoIdentidad, String rol);

}
