package com.frontcrm.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProformaDTO {
	@JsonProperty("proformaCabDTO")
	private ProformaCabDTO proformaCabDTO;
	@JsonProperty("lstProformaDetDTO")
	private List<ProformaDetDTO> lstProformaDetDTO;
	@JsonProperty("lstDelProformaDetDTO")
	private List<ProformaDetDTO> lstDelProformaDetDTO;

}
