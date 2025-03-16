package com.proyecto.medihealth.administrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.medihealth.administrador.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {}
