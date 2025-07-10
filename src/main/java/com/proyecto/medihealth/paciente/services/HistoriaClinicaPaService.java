package com.proyecto.medihealth.paciente.services;

import com.proyecto.medihealth.common.models.RecordMedico;
import com.proyecto.medihealth.paciente.dtos.HistoriaClinicaPaDTO;
import com.proyecto.medihealth.paciente.repositories.HistoriaClinicaPaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HistoriaClinicaPaService {

    @Autowired
    private HistoriaClinicaPaRepository historiaClinicaPaRepository;

    public List<HistoriaClinicaPaDTO> obtenerHistoriaClinicaPorDocumentoIdentidad(String documentoIdentidad) {
        List<Object[]> resultados = historiaClinicaPaRepository.findHistoriaCompletaByDocumento(documentoIdentidad);

        HistoriaClinicaPaDTO dto = null;
        List<RecordMedico> records = new ArrayList<>();

        for (Object[] fila : resultados) {
            if (dto == null) {
                dto = new HistoriaClinicaPaDTO();
                dto.setIdUsuario((Integer) fila[0]);
                dto.setDocumentoIdentidad((String) fila[1]);
                dto.setNombre((String) fila[2]);
                dto.setApellido((String) fila[3]);
                dto.setTelefono((String) fila[4]);
                dto.setCorreo((String) fila[5]);
                dto.setRol((String) fila[6]);
                dto.setIdPaciente((Integer) fila[7]);
                dto.setHistorialMedico((String) fila[8]);
                dto.setNumeroSeguro((String) fila[9]);
                dto.setFechaNacimiento((Date) fila[10]);
                dto.setSexo((Character) fila[11]);
                dto.setDireccion((String) fila[12]);
                dto.setUltimaCita((Date) fila[13]);
                dto.setProximaCita((Date) fila[14]);
                dto.setHcId((Integer) fila[15]);
                dto.setNumeroHistoria((Integer) fila[16]);
                dto.setFechaCreacion((String) fila[17]);
                dto.setContactoEmergencia((String) fila[18]);
                dto.setTelefonoEmergencia((Integer) fila[19]);
                dto.setAntecedentesMedicos((String) fila[20]);
            }

            // Validar si hay record médico (puede venir null por el LEFT JOIN)
            if (fila[21] != null) {
                RecordMedico record = new RecordMedico();
                record.setId((Integer) fila[21]);
                record.setRecordMedico((String) fila[22]);
                record.setFechaRegistro((String) fila[23]);
                record.setSignosVitales((String) fila[24]);
                record.setMotivoConsulta((String) fila[25]);
                record.setEspecialidad((String) fila[26]);
                record.setDiagnostico((String) fila[27]);
                record.setNombreMedico((String) fila[28]);
                records.add(record);
            }
        }

        if (dto != null) {
            dto.setRecords(records);
            return List.of(dto);
        }

        return new ArrayList<>();
    }




}
