package com.frontcrm.service;

import java.util.List;

import com.frontcrm.dto.AdmiProductoDTO;
import com.frontcrm.dto.ProformaCabDTO;
import com.frontcrm.dto.ProformaDTO;
import com.frontcrm.dto.ProformaDetDTO;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

@Stateless
public class ProfromaService {

	   private static final String BASE_URL = "http://localhost:8080/crm/api/proforma";

	    private final Client client = ClientBuilder.newClient();


	    public List<ProformaCabDTO> getAll() {
	        return client
	                .target(BASE_URL)
	                .request(MediaType.APPLICATION_JSON)
	                .get(new GenericType<List<ProformaCabDTO>>() {});
	    }
	    
	    
	    public List<ProformaDetDTO> getDetalles(ProformaDTO dto) {
	        return client
	                .target(BASE_URL+"/buscarDet")
	                .request(MediaType.APPLICATION_JSON)
	                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), new GenericType<List<ProformaDetDTO>>() {});
	    }


	    public ProformaDTO create(ProformaDTO dto) {
	        return client
	                .target(BASE_URL)
	                .request(MediaType.APPLICATION_JSON)
	                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), ProformaDTO.class);
	    }

	    public ProformaDTO update(AdmiProductoDTO dto) {
	        return client
	                .target(BASE_URL)
	                .request(MediaType.APPLICATION_JSON)
	                .put(Entity.entity(dto, MediaType.APPLICATION_JSON), ProformaDTO.class);
	    }

}
