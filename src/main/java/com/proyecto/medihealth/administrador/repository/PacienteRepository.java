package com.proyecto.medihealth.administrador.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.medihealth.administrador.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {}
