package com.smartheal.resultadoservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "resultado")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idResult;
    private String nameMedic;
    private int idUser;
    private String nameSpecialty;
    private String diagnosis;
    private String treatment;
    private String recommendations;
    private Boolean state = true;
}
