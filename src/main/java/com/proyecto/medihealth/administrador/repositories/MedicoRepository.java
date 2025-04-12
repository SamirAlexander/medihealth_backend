package com.proyecto.medihealth.administrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.medihealth.common.models.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {}
