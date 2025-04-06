package com.frontcrm.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProformaCabDTO {
	@JsonProperty("idProformaCab")
    private Long idProformaCab;
	@JsonProperty("numero")
    private String numero;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonProperty("feValidez")
    private Date feValidez;
	@JsonProperty("condicionPago")
    private String condicionPago;
	@JsonProperty("formaPago")
    private String formaPago;
	@JsonProperty("estado")
    private String estado;
	@JsonProperty("impuesto")
    private Double impuesto;
	@JsonProperty("descuento")
    private Double descuento;
	@JsonProperty("persona")
    private InfoPersonaDTO persona;
}