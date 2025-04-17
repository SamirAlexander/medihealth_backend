package com.proyecto.medihealth.administrador.services;

import com.proyecto.medihealth.administrador.dtos.HistoriaClinicaDTO;
import com.proyecto.medihealth.administrador.dtos.RecordMedicoDTO;
import com.proyecto.medihealth.administrador.repositories.HistoriaClinicaRepository;
import com.proyecto.medihealth.administrador.repositories.RecordMedicoRepository;
import com.proyecto.medihealth.administrador.repositories.UsuarioRepository;
import com.proyecto.medihealth.common.models.HistoriaClinica;
import com.proyecto.medihealth.common.models.RecordMedico;
import com.proyecto.medihealth.common.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RecordMedicoRepository recordMedicoRepository;

    //OBTERNER TODAS LAS HISTORIAS CLINICAS DE PACIENTE
    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    //OBTERNER HISTORIAS CLINICAS SIN RECORD MEDICO
    public List<HistoriaClinica> obtenerHistoriasClinicasSinRecords() {
        List<HistoriaClinica> historias = historiaClinicaRepository.findAll();
        for (HistoriaClinica historia : historias) {
            historia.setRecordsMedicos(new ArrayList<>());
        }
        return historias;
    }

    //OBTERNER HISTORIA CLINICA POR ID DE UN PACIENTE
    public HistoriaClinica obtenerHistoriaClinicaPorId(int id) {
        return historiaClinicaRepository.findById(id).orElse(null);
    }

    //OBTERNER HISTORIA CLINICA POR DOCUMENTO DE IDENTIDAD
    public Usuario obtenerHistoriaClinicaPorDocumentoIdentidad(String id) {
        return usuarioRepository.findByDocumentoIdentidad(id).orElse(null);
                //historiaClinicaRepository.findByPaciente_Usuario_DocumentoIdentidad(id).orElse(null);
    }

    // ELIMINAR HISTORIA CLINICA POR ID DE UN PACIENTE
    public void eliminarHistoriaClinicaPorId(int id) {
        historiaClinicaRepository.deleteById(id);
    }

    // CREAR HISTORIA CLINICA
    /*public HistoriaClinica createHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }*/

    public HistoriaClinica createHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setPacienteId(historiaClinicaDTO.getPacienteId());
        historiaClinica.setFechaCreacion(historiaClinicaDTO.getFechaCreacion());
        historiaClinica.setContactoEmergencia(historiaClinicaDTO.getContactoEmergencia());
        historiaClinica.setTelefonoEmergencia(historiaClinicaDTO.getTelefonoEmergencia());
        historiaClinica.setAntecedentesMedicos(historiaClinicaDTO.getAntecedentesMedicos());

        // Generar número de historia si no viene en el DTO
        if(historiaClinicaDTO.getNumeroHistoria() == null) {
            historiaClinica.setNumeroHistoria(generarNumeroHistoria());
        } else {
            historiaClinica.setNumeroHistoria(historiaClinicaDTO.getNumeroHistoria());
        }

        // Guardar la historia clínica primero
        HistoriaClinica historiaGuardada = historiaClinicaRepository.save(historiaClinica);

        // Guardar los records médicos asociados
        if(historiaClinicaDTO.getRecordsMedicos() != null && !historiaClinicaDTO.getRecordsMedicos().isEmpty()) {
            List<RecordMedico> recordsMedicos = new ArrayList<>();

            for(RecordMedicoDTO recordDTO : historiaClinicaDTO.getRecordsMedicos()) {
                RecordMedico recordMedico = new RecordMedico();
                recordMedico.setRecordMedico(recordDTO.getRecordMedico());
                recordMedico.setFechaRegistro(recordDTO.getFechaRegistro());
                recordMedico.setHistoriaClinica(historiaGuardada);
                recordMedico.setSignosVitales(recordDTO.getSignosVitales());
                recordMedico.setMotivoConsulta(recordDTO.getMotivoConsulta());
                recordMedico.setEspecialidad(recordDTO.getEspecialidad());
                recordMedico.setDiagnostico(recordDTO.getDiagnostico());
                recordMedico.setNombreMedico(recordDTO.getNombreMedico());



                recordsMedicos.add(recordMedico);
            }

            recordMedicoRepository.saveAll(recordsMedicos);
            historiaGuardada.setRecordsMedicos(recordsMedicos);
        }

        return historiaGuardada;
    }

    private Long generarNumeroHistoria() {
        // Implementación simple - en producción usarías una secuencia o método más robusto
        return System.currentTimeMillis();
    }
}
