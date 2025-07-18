package com.proyecto.medihealth.paciente.repositories;

import com.proyecto.medihealth.common.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientePRepository extends JpaRepository<Paciente, Integer> {

    @Query("SELECT p FROM Paciente p JOIN p.usuario u WHERE u.documentoIdentidad = :documento")
    Paciente buscarPorDocumento(@Param("documento") String documento);
}