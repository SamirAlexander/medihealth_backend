package com.proyecto.medihealth.medico.repositories;

import com.proyecto.medihealth.common.models.RecordMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NuevoRecordMedicoRepository extends JpaRepository<RecordMedico, Integer> {
}
