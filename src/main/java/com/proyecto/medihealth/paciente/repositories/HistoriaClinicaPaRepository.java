package com.proyecto.medihealth.paciente.repositories;

import com.proyecto.medihealth.common.models.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriaClinicaPaRepository extends JpaRepository<HistoriaClinica, Integer> {

    @Query(value = """
            SELECT 
                u.id_usuario,
                u.documento_identidad,
                u.nombre,
                u.apellido,
                u.telefono,
                u.correo,
                u.rol,
            
                p.id_paciente,
                p.historial_medico,
                p.numero_seguro,
                p.fecha_nacimiento,
                p.sexo,
                p.direccion,
                p.ultima_cita,
                p.proxima_cita,
            
                hc.id,
                hc.numero_historia,
                hc.fecha_creacion,
                hc.contacto_emergencia,
                hc.telefono_emergencia,
                hc.antecedentes_medicos,
            
                rm.id,
                rm.record_medico,
                rm.fecha_registro,
                rm.signos_vitales,
                rm.motivo_consulta,
                rm.especialidad,
                rm.diagnostico,
                rm.nombre_medico
            FROM usuarios u
            JOIN pacientes p ON u.documento_identidad = p.documento_identidad
            JOIN historia_clinica hc ON p.id_paciente = hc.id_paciente
            LEFT JOIN record_medico rm ON hc.id = rm.numero_historia
            WHERE u.documento_identidad = :documento
            ORDER BY rm.fecha_registro DESC
            """, nativeQuery = true)
    List<Object[]> findHistoriaCompletaByDocumento(@Param("documento") String documentoIdentidad);
}
