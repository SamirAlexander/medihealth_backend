package com.proyecto.medihealth.medico.services;


import com.proyecto.medihealth.common.models.Usuario;
import com.proyecto.medihealth.medico.repositories.DatossPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatossPersonalesService {

    @Autowired
    private DatossPersonalesRepository datossPersonalesRepository;

    // Obtener Datos Personales por documento de identidad
    public Usuario obtenerDatossPersonalesPordocumentoIdentidad(String documentoIdentidad) {
        try {
            return datossPersonalesRepository.findByDocumentoIdentidadAndRol(documentoIdentidad, "Medico")
                    .orElseThrow(() -> new RuntimeException("Documento no encontrado para Medico: " + documentoIdentidad));
        } catch (Exception e) {
            throw new RuntimeException("El documento no corresponde a Medico: " + e.getMessage());
        }
    }
    // Actualizar Datos Personales por documento de identidad
    public Usuario actualizarDatossPersonales(String documentoIdentidad, Usuario datossPersonales) {
        try {
            Usuario usuarioExistente = datossPersonalesRepository.findByDocumentoIdentidadAndRol(documentoIdentidad, "Medico")
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con documento: " + documentoIdentidad));

            // Actualizar los campos deseados
            usuarioExistente.setNombre(datossPersonales.getNombre());
            usuarioExistente.setApellido(datossPersonales.getApellido());
            usuarioExistente.setTelefono(datossPersonales.getTelefono());
            usuarioExistente.setCorreo(datossPersonales.getCorreo());

            return datossPersonalesRepository.save(usuarioExistente);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar los datos personales: " + e.getMessage());
        }
    }

}
