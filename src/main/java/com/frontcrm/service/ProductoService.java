package com.frontcrm.service;

import java.util.List;

import com.frontcrm.dto.AdmiProductoDTO;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

@Stateless
public class ProductoService {
    private static final String BASE_URL = "http://localhost:8080/crm/api/producto";

    private final Client client = ClientBuilder.newClient();

    public AdmiProductoDTO getById(Long id) {
        return client
                .target(BASE_URL + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(AdmiProductoDTO.class);
    }

    public List<AdmiProductoDTO> getAll() {
        return client
                .target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<AdmiProductoDTO>>() {});
    }

    public AdmiProductoDTO create(AdmiProductoDTO dto) {
        return client
                .target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), AdmiProductoDTO.class);
    }

    public AdmiProductoDTO update(AdmiProductoDTO dto) {
        return client
                .target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(dto, MediaType.APPLICATION_JSON), AdmiProductoDTO.class);
    }


}
