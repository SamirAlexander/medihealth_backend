package com.proyecto.medihealth.administrador.repositories;

import com.proyecto.medihealth.common.models.RecordMedico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordMedicoRepository extends JpaRepository<RecordMedico, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por un campo específico
    // List<Medico> findByNombre(String nombre);
}
