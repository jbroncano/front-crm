package com.frontcrm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdmiRolDTO {
	 @JsonProperty("idRol")
    private Long idRol;
	 @JsonProperty("nombre")
    private String nombre;
	 @JsonProperty("descripcion")
    private String descripcion;
	 @JsonProperty("estado")
    private String estado;
}