package com.frontcrm.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdmiProductoDTO {
	 @JsonProperty("idProducto")
    private Long idProducto;
	 @JsonProperty("nombre")
    private String nombre;
	 @JsonProperty("descripcion")
    private String descripcion;
	 @JsonProperty("precio")
    private Double precio;
	 @JsonProperty("estado")
    private String estado;
	 
}