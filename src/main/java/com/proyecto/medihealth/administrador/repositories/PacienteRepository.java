package com.proyecto.medihealth.administrador.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.medihealth.common.models.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
