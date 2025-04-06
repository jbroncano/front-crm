package com.frontcrm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProspectoDTO {
	
	    @JsonProperty("infoPersonaDTO")
	    private InfoPersonaDTO  infoPersonaDTO;
		 @JsonProperty("rolId")
		 private Long rolId;
		 @JsonProperty("infoUsuarioDTO")
		 private InfoUsuarioDTO  infoUsuarioDTO;


}
