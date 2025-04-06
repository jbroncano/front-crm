package com.frontcrm.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoUsuarioDTO {
	 @JsonProperty("idUsuario")
    private Long idUsuario;
	 @JsonProperty("usuario")
    private String usuario;
	 @JsonProperty("password")
    private String password;
	 @JsonProperty("estado")
    private String estado;
	 @JsonProperty("persona")
    private InfoPersonaDTO persona;
	 @JsonProperty("rol")
    private AdmiRolDTO rol;
}