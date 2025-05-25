package com.proyecto.medihealth.medico.services;


import com.proyecto.medihealth.medico.dtos.AgendaDelDiaDTO;
import com.proyecto.medihealth.medico.repositories.AgendaDelDiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AgendaDelDiaService {

    private final AgendaDelDiaRepository agendaDelDiaRepository;

    @Autowired
    public AgendaDelDiaService(AgendaDelDiaRepository agendaDelDiaRepository) {
        this.agendaDelDiaRepository = agendaDelDiaRepository;
    }

    public List<AgendaDelDiaDTO> obtenerAgendaDelDia(Integer idConsultorio, LocalDate fecha) {
        if (fecha == null) {
            fecha = LocalDate.now();
        }
        return agendaDelDiaRepository.findAgendaDelDiaByConsultorio(fecha, idConsultorio);
    }

    public List<AgendaDelDiaDTO> obtenerAgendaHoy(Integer idConsultorio) {
        return obtenerAgendaDelDia(idConsultorio, LocalDate.now());
    }
}