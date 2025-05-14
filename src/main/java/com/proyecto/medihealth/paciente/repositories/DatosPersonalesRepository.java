package com.proyecto.medihealth.paciente.repositories;


import com.proyecto.medihealth.common.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DatosPersonalesRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByDocumentoIdentidadAndRol(String documentoIdentidad, String rol);

    // Optional<DatosPersonales> findBy(String documentoIdentidad);
}
