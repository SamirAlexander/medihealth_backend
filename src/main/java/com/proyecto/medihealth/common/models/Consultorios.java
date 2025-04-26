package com.proyecto.medihealth.common.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "consultorios")
@Getter
@Setter
public class Consultorios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsultorio", nullable = false)
    private int idConsultorio;

    @Column(name = "nombreConsultorio", nullable = false)
    private String numeroConsultorio;

    @OneToMany (mappedBy = "consultorios")
    @JoinColumn(name = "id_medico", nullable = false)
    @JsonIgnoreProperties("idMedico")
    private Medico medico;

}
