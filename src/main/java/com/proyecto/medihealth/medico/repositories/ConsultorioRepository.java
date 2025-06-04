package com.proyecto.medihealth.medico.repositories;

import com.proyecto.medihealth.common.models.Consultorios;
import com.proyecto.medihealth.medico.dtos.ConsultorioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorios, Integer> {


}
