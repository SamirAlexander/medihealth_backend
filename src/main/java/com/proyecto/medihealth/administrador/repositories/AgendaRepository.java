package com.proyecto.medihealth.administrador.repositories;

public interface AgendaRepository
extends org.springframework.data.jpa.repository.JpaRepository<com.proyecto.medihealth.common.models.Agenda, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar agendas por fecha:
    // List<Agenda> findByFechaCita(Date fechaCita);
}
