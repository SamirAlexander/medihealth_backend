package com.proyecto.medihealth.administrador.repositories;

import com.proyecto.medihealth.common.models.Agenda;

import java.sql.Date;

public interface AgendaRepository
extends org.springframework.data.jpa.repository.JpaRepository<Agenda, Integer> {
    boolean existsByFechaCita(Date date);
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar agendas por fecha:
    // List<Agenda> findByFechaCita(Date fechaCita);
}
