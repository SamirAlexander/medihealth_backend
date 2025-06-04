package com.proyecto.medihealth.common.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medicos")  // Se ajusta el nombre de la tabla a Medicos
@Getter
@Setter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedico")
    private int idMedico;

    @Column(name = "dependencia", nullable = false, length = 100)
    private String dependencia;

    @Column(name = "horarioTrabajo", nullable = false, length = 50)
    private String horarioTrabajo;    

    @Column(name = "numeroLicencia", nullable = true, length = 20)
    private String numeroLicencia;

    @Column(name = "especialidad", nullable = true, length = 100)
    private String especialidad;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documentoIdentidad", referencedColumnName = "documentoIdentidad", nullable = false)
    @JsonIgnoreProperties("medico")
    private Usuario usuario;


}



