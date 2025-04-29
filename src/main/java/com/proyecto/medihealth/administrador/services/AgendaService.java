package com.proyecto.medihealth.administrador.services;

import com.proyecto.medihealth.administrador.data.PeriodoAgendaRequest;
import com.proyecto.medihealth.administrador.data.PeriodoAgendaResponse;
import com.proyecto.medihealth.administrador.dtos.AgendaDTO;
import com.proyecto.medihealth.administrador.repositories.AgendaRepository;
import com.proyecto.medihealth.administrador.repositories.ConsultoriosRepository;
import com.proyecto.medihealth.administrador.repositories.DetalleAgendaRepository;
import com.proyecto.medihealth.common.models.Agenda;
import com.proyecto.medihealth.common.models.Consultorios;
import com.proyecto.medihealth.common.models.DetalleAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private DetalleAgendaRepository detalleAgendaRepository;

    @Autowired
    private ConsultoriosRepository consultoriosRepository;



    // Método para crear una nueva agenda
    // GET /administrador/agenda
    public List<Agenda> obtenerAgendas() {
        List<Agenda> agendas = agendaRepository.findAll();
        return agendas;
    }

    // Método para obtener una agenda por su ID
    public Agenda obtenerAgendaPorId(int id) {
        return agendaRepository.findById(id).orElse(null);
    }


    //*******************************//
    // Método para crear una nueva agenda
    public PeriodoAgendaResponse crearAgendaPeriodo(PeriodoAgendaRequest request) {
        // Validar el request
        validarRequest(request);

        List<LocalDate> fechasGeneradas = new ArrayList<>();
        int totalAgendasCreadas = 0;
        int totalDetallesCreados = 0;

        // Obtener todos los consultorios disponibles
        List<Consultorios> consultorios = consultoriosRepository.findAll();
        if (consultorios.size() < request.getNumeroConsultorios()) {
            throw new RuntimeException("No hay suficientes consultorios registrados");
        }

        // Iterar por cada día en el rango de fechas
        LocalDate fechaActual = request.getFechaInicio();
        while (!fechaActual.isAfter(request.getFechaFin())) {
            // Verificar si ya existe una agenda para esta fecha
            if (!agendaRepository.existsByFechaCita(Date.valueOf(fechaActual))) {
                Agenda agenda = crearAgendaParaFecha(fechaActual, request.getEstadoDiaDefault());
                totalDetallesCreados += crearDetallesAgenda(agenda, consultorios, request);
                totalAgendasCreadas++;
                fechasGeneradas.add(fechaActual);
            }
            fechaActual = fechaActual.plusDays(1);
        }

        return new PeriodoAgendaResponse(
                "success",
                "Período de booking creado exitosamente",
                totalAgendasCreadas,
                totalDetallesCreados,
                fechasGeneradas
        );
    }

    private Agenda crearAgendaParaFecha(LocalDate fecha, String estadoDia) {
        Agenda agenda = new Agenda();
        agenda.setFechaCita(Date.valueOf(fecha));
        agenda.setEstadoDia(estadoDia);
        agenda.setDetalleAgenda(new ArrayList<>());
        return agendaRepository.save(agenda);
    }

    private int crearDetallesAgenda(Agenda agenda, List<Consultorios> consultorios, PeriodoAgendaRequest request) {
        int detallesCreados = 0;
        LocalTime horaInicio = LocalTime.parse(request.getHoraInicioJornada());
        LocalTime horaFin = LocalTime.parse(request.getHoraFinJornada());
        int duracionCita = request.getDuracionCitaMinutos();

        // Iterar por cada consultorio
        for (int i = 0; i < request.getNumeroConsultorios(); i++) {
            Consultorios consultorio = consultorios.get(i);

            // Generar franjas horarias para este consultorio
            LocalTime horaActual = horaInicio;
            while (horaActual.plusMinutes(duracionCita).isBefore(horaFin) ||
                    horaActual.plusMinutes(duracionCita).equals(horaFin)) {

                DetalleAgenda detalle = new DetalleAgenda();
                detalle.setHoraInicio(Time.valueOf(horaActual));
                detalle.setHoraFin(Time.valueOf(horaActual.plusMinutes(duracionCita)));
                detalle.setDisponibilidad("DISPONIBLE");
                detalle.setAgendas(agenda);
                detalle.setConsultorios(consultorio);
                detalle.setPaciente(null); // Inicialmente no hay paciente asignado

                detalleAgendaRepository.save(detalle);
                agenda.getDetalleAgenda().add(detalle);

                detallesCreados++;
                horaActual = horaActual.plusMinutes(duracionCita);
            }
        }

        agendaRepository.save(agenda);
        return detallesCreados;
    }

    private void validarRequest(PeriodoAgendaRequest request) {
        if (request.getFechaInicio() == null || request.getFechaFin() == null) {
            throw new IllegalArgumentException("Las fechas de inicio y fin son requeridas");
        }

        if (request.getFechaFin().isBefore(request.getFechaInicio())) {
            throw new IllegalArgumentException("La fecha fin no puede ser anterior a la fecha inicio");
        }

        if (request.getNumeroConsultorios() <= 0) {
            throw new IllegalArgumentException("El número de consultorios debe ser mayor a cero");
        }

        try {
            LocalTime.parse(request.getHoraInicioJornada());
            LocalTime.parse(request.getHoraFinJornada());
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de hora inválido. Use HH:mm:ss");
        }

        if (request.getDuracionCitaMinutos() <= 0) {
            throw new IllegalArgumentException("La duración de la cita debe ser mayor a cero");
        }
    }







}
