package com.proyecto.medihealth.medico.services;


import com.proyecto.medihealth.common.models.HistoriaClinica;
import com.proyecto.medihealth.common.models.RecordMedico;
import com.proyecto.medihealth.medico.dtos.NuevoRecordMedicoDTO;
import com.proyecto.medihealth.medico.repositories.HistoriaClinicaPRepository;
import com.proyecto.medihealth.medico.repositories.NuevoRecordMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NuevoRecordMedicoService {
    @Autowired
    private NuevoRecordMedicoRepository NuevorecordMedicoRepository;
    @Autowired
    private HistoriaClinicaPRepository historiaClinicaPRepository;

    //GET /medico/nuevo-record-medicos/{id}
    // Obtener Historia Clinica por ID (Item).
    public HistoriaClinica obtenerHistoriaClinicaPorId(int id) {
        return historiaClinicaPRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada"));
    }

    //PUT Agregar Record Medico a Historia Clinica.
    public RecordMedico agregarRecordAHistoriaClinica(int historiaId, NuevoRecordMedicoDTO nuevoRecordMedicoDTO) {
        HistoriaClinica historia = obtenerHistoriaClinicaPorId(historiaId);

        RecordMedico nuevoRecord = new RecordMedico();
        nuevoRecord.setRecordMedico(nuevoRecordMedicoDTO.getRecordMedico());
        nuevoRecord.setFechaRegistro(nuevoRecordMedicoDTO.getFechaRegistro());
        nuevoRecord.setHistoriaClinica(historia);
        nuevoRecord.setSignosVitales(nuevoRecordMedicoDTO.getSignosVitales());
        nuevoRecord.setMotivoConsulta(nuevoRecordMedicoDTO.getMotivoConsulta());
        nuevoRecord.setEspecialidad(nuevoRecordMedicoDTO.getEspecialidad());
        nuevoRecord.setDiagnostico(nuevoRecordMedicoDTO.getDiagnostico());
        nuevoRecord.setNombreMedico(nuevoRecordMedicoDTO.getNombreMedico());

        RecordMedico recordGuardado = NuevorecordMedicoRepository.save(nuevoRecord);

        // Actualizar la relación en la historia clínica
        if (historia.getRecordsMedicos() == null) {
            historia.setRecordsMedicos(new ArrayList<>());
        }
        historia.getRecordsMedicos().add(recordGuardado);
        historiaClinicaPRepository.save(historia);

        return recordGuardado;
    }

}
