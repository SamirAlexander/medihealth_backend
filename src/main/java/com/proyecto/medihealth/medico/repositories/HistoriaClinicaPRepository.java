package com.proyecto.medihealth.medico.repositories;

import com.proyecto.medihealth.common.models.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoriaClinicaPRepository extends JpaRepository<HistoriaClinica, Integer> {
    Optional<HistoriaClinica> findByNumeroHistoria(long numeroHistoria);
    Optional<HistoriaClinica> findByPaciente_Usuario_DocumentoIdentidad(String documentoIdentidad);

}

