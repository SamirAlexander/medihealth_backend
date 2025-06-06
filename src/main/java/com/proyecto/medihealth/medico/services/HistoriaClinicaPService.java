package com.proyecto.medihealth.medico.services;


import com.proyecto.medihealth.common.models.HistoriaClinica;
import com.proyecto.medihealth.medico.repositories.HistoriaClinicaPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriaClinicaPService {

    @Autowired
    private HistoriaClinicaPRepository historiaClinicaPRepository;
    // Método para obtener Historia Clinica por ID
    public HistoriaClinica obtenerHistoriaClinicaPorId(int id) {
        return historiaClinicaPRepository.findById(id).orElse(null);
    }
    // Método para obtener Historia Clinica por Documento de Identidad
    public HistoriaClinica obtenerHistoriaClinicaPorDocumentoIdentidad(String documentoIdentidad) {
        return historiaClinicaPRepository.findByPaciente_Usuario_DocumentoIdentidad(documentoIdentidad).orElse(null);
    }
}
