package com.proyecto.medihealth.administrador.services;

import com.proyecto.medihealth.administrador.dtos.RecordMedicoDTO;
import com.proyecto.medihealth.administrador.repositories.HistoriaClinicaRepository;
import com.proyecto.medihealth.administrador.repositories.RecordMedicoRepository;
import com.proyecto.medihealth.common.models.HistoriaClinica;
import com.proyecto.medihealth.common.models.RecordMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecordMedicoService {
    @Autowired
    private RecordMedicoRepository recordMedicoRepository;

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;


    //PUT Agregar Record Medico a Historia Clinica.
    public RecordMedico agregarRecordAHistoria(int historiaId, RecordMedicoDTO recordMedicoDTO) {
        HistoriaClinica historia = obtenerHistoriaClinicaPorId(historiaId);

        RecordMedico nuevoRecord = new RecordMedico();
        nuevoRecord.setRecordMedico(recordMedicoDTO.getRecordMedico());
        nuevoRecord.setFechaRegistro(recordMedicoDTO.getFechaRegistro());
        nuevoRecord.setHistoriaClinica(historia);

        RecordMedico recordGuardado = recordMedicoRepository.save(nuevoRecord);

        // Actualizar la relación en la historia clínica
        if(historia.getRecordsMedicos() == null) {
            historia.setRecordsMedicos(new ArrayList<>());
        }
        historia.getRecordsMedicos().add(recordGuardado);
        historiaClinicaRepository.save(historia);

        return recordGuardado;
    }


    public HistoriaClinica obtenerHistoriaClinicaPorId(int id) {
        return historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada"));
    }

    public HistoriaClinica obtenerHistoriaClinicaPorNumeroHistoria(long id) {
        return historiaClinicaRepository.findByNumeroHistoria(id)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada"));
    }



}
