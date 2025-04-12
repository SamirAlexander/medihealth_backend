package com.proyecto.medihealth.administrador.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.medihealth.common.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {}
