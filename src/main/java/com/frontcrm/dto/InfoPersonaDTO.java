package com.frontcrm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoPersonaDTO {
	 @JsonProperty("idPersona")
    private Long idPersona;
	 @JsonProperty("identificacion")
    private String identificacion;
	 @JsonProperty("nombre")
    private String nombre;
	 @JsonProperty("apellido")
    private String apellido;
	 @JsonProperty("direccion")
    private String direccion;
	 @JsonProperty("estado")
    private String estado;
	 @JsonProperty("razonSocial")
    private String razonSocial;

}