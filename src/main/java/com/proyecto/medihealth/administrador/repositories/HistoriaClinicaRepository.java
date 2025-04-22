package com.proyecto.medihealth.administrador.repositories;

import com.proyecto.medihealth.common.models.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer> {

    Optional<HistoriaClinica> findByNumeroHistoria(long numeroHistoria);
    Optional<HistoriaClinica> findByPaciente_Usuario_DocumentoIdentidad(String documentoIdentidad);



}
