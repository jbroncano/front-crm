package com.frontcrm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProformaDetDTO {
	@JsonProperty("idProformaDet")
    private Long idProformaDet;
	@JsonProperty("proformaCab")
    private ProformaCabDTO proformaCab;
	@JsonProperty("producto")
    private AdmiProductoDTO producto;
	@JsonProperty("cantidad")
    private String cantidad;
	@JsonProperty("estado")
    private String estado;
}