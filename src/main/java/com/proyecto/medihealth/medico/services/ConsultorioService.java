package com.proyecto.medihealth.medico.services;

import com.proyecto.medihealth.common.models.Consultorios;
import com.proyecto.medihealth.medico.dtos.ConsultorioDTO;
import com.proyecto.medihealth.medico.repositories.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultorioService {

    private final ConsultorioRepository consultorioRepository;

    @Autowired
    public ConsultorioService(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }

    public List<Consultorios> obtenerTodosLosConsultorios() {
        return consultorioRepository.findAll();
    }


}
