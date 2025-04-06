package com.frontcrm.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProformaCabHistorialDTO {
    private Long id;
    private ProformaCabDTO proformaCab;
    private String estadoActual;
    private String nuevoEstado;
    private String observacion;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "fe_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime feCreacion;
}