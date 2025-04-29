package com.proyecto.medihealth.administrador.services;

import com.proyecto.medihealth.administrador.repositories.AgendaRepository;
import com.proyecto.medihealth.common.models.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;



    // Método para crear una nueva agenda
    // GET /administrador/agenda
    public List<Agenda> obtenerAgendas() {
        List<Agenda> agendas = agendaRepository.findAll();
        return agendas;
    }





}
