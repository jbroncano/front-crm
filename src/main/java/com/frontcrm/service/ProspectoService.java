package com.frontcrm.service;

import java.util.List;

import com.frontcrm.dto.InfoPersonaDTO;
import com.frontcrm.dto.ProspectoDTO;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;


@Stateless
public class ProspectoService {
	
	  private static final String BASE_URL = "http://localhost:8080/crm/api/persona";

	    private final Client client = ClientBuilder.newClient();

	    public InfoPersonaDTO getById(Long id) {
	        return client
	                .target(BASE_URL + "/" + id)
	                .request(MediaType.APPLICATION_JSON)
	                .get(InfoPersonaDTO.class);
	    }

	    public List<InfoPersonaDTO> getAll() {
	        return client
	                .target(BASE_URL)
	                .request(MediaType.APPLICATION_JSON)
	                .get(new GenericType<List<InfoPersonaDTO>>() {});
	    }

	    public InfoPersonaDTO create(InfoPersonaDTO dto) {
	    	ProspectoDTO res=new ProspectoDTO();
	    	res.setInfoPersonaDTO(dto);
	        return client
	                .target(BASE_URL+"/crearProspecto")
	                .request(MediaType.APPLICATION_JSON)
	                .post(Entity.entity(res, MediaType.APPLICATION_JSON), InfoPersonaDTO.class);
	    }

	    public InfoPersonaDTO update(InfoPersonaDTO dto) {
	    	ProspectoDTO res=new ProspectoDTO();
	    	res.setInfoPersonaDTO(dto);
	        return client
	                .target(BASE_URL+"/actualizarProspecto")
	                .request(MediaType.APPLICATION_JSON)
	                .put(Entity.entity(res, MediaType.APPLICATION_JSON), InfoPersonaDTO.class);
	    }

}
