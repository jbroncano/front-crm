package com.frontcrm.service;

import java.util.List;

import com.frontcrm.dto.AdmiRolDTO;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

@Stateless
public class RolService {

    private static final String BASE_URL = "http://localhost:8080/crm/api/rol";

    private final Client client = ClientBuilder.newClient();

    public AdmiRolDTO getById(Long id) {
        return client
                .target(BASE_URL + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(AdmiRolDTO.class);
    }

    public List<AdmiRolDTO> getAll() {
        return client
                .target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<AdmiRolDTO>>() {});
    }

    public AdmiRolDTO create(AdmiRolDTO dto) {
        return client
                .target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), AdmiRolDTO.class);
    }

    public AdmiRolDTO update(AdmiRolDTO dto) {
        return client
                .target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(dto, MediaType.APPLICATION_JSON), AdmiRolDTO.class);
    }

}
