package com.proyecto.medihealth.administrador.services;

import com.proyecto.medihealth.administrador.repositories.HistoriaClinicaRepository;
import com.proyecto.medihealth.common.models.HistoriaClinica;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    //OBTERNER TODAS LAS HISTORIAS CLINICAS DE PACIENTE
    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }
    //OBTERNER HISTORIA CLINICA POR ID DE UN PACIENTE
    public HistoriaClinica obtenerHistoriaClinicaPorId(int id) {
        return historiaClinicaRepository.findById(id).orElse(null);
    }
    // ELIMINAR HISTORIA CLINICA POR ID DE UN PACIENTE
    public void eliminarHistoriaClinicaPorId(int id) {
        historiaClinicaRepository.deleteById(id);
    }
}
