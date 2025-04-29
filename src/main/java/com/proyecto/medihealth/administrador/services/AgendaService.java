package com.proyecto.medihealth.administrador.services;

import com.proyecto.medihealth.administrador.dtos.AgendaDTO;
import com.proyecto.medihealth.administrador.dtos.DetalleAgendaDTO;
import com.proyecto.medihealth.administrador.repositories.AgendaRepository;
import com.proyecto.medihealth.administrador.repositories.DetalleAgendaRepository;
import com.proyecto.medihealth.common.models.Agenda;
import com.proyecto.medihealth.common.models.DetalleAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private DetalleAgendaRepository detalleAgendaRepository;

    // Método para crear una nueva agenda
    // GET /administrador/agenda
    public List<AgendaDTO> obtenerAgendas() {
        List<Agenda> agendas = agendaRepository.findAll();
        List<AgendaDTO> agendaDTOs = new ArrayList<>();

        for (Agenda agenda : agendas) {
            AgendaDTO agendaDTO = new AgendaDTO();
            agendaDTO.setIdAgenda(agenda.getIdAgenda());
            agendaDTO.setFechaCita(agenda.getFechaCita());
            agendaDTO.setEstadoDia(agenda.getEstadoDia());
            agendaDTOs.add(agendaDTO);
        }

        return agendaDTOs;
    }
    // metodo para listar detalle de agendas
    // GET /administrador/agenda/detallegenda
    public List<DetalleAgenda> obtenerDetalleAgendas() {


        return detalleAgendaRepository.findAll(); }



}
