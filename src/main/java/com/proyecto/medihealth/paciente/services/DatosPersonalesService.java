package com.proyecto.medihealth.paciente.services;

import com.proyecto.medihealth.common.models.Usuario;
import com.proyecto.medihealth.paciente.repositories.DatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosPersonalesService {

    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;



    // Método para obtener los datos personales por ID
    public Usuario obtenerDatosPersonalesPordocumentoIdentidad(String documentoIdentidad) {
        try {
            return datosPersonalesRepository.findByDocumentoIdentidadAndRol(documentoIdentidad, "Paciente")
                    .orElseThrow(() -> new RuntimeException("Documento no encontrado para Paciente: " + documentoIdentidad));
        } catch (Exception e) {
            throw new RuntimeException("El documento no corresponde a Paciente: " + e.getMessage());
        }
        //java.util.Optional<DatosPersonales> datosPersonales = datosPersonalesRepository.findBy(documentoIdentidad);
        //return datosPersonales.orElse(null);
    }


    // Método para editar un dato personal por documento de identidad sin modificar el documento de identidad
    public Usuario actualizarDatosPersonales(String documentoIdentidad, Usuario datosPersonales) {
        try {
            Usuario usuarioExistente = datosPersonalesRepository.findByDocumentoIdentidadAndRol(documentoIdentidad, "Paciente")
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con documento: " + documentoIdentidad));

            // Actualizar los campos deseados
            usuarioExistente.setNombre(datosPersonales.getNombre());
            usuarioExistente.setApellido(datosPersonales.getApellido());
            usuarioExistente.setTelefono(datosPersonales.getTelefono());
            usuarioExistente.setCorreo(datosPersonales.getCorreo());


            return datosPersonalesRepository.save(usuarioExistente);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar los datos personales: " + e.getMessage());
        }

    }
}
