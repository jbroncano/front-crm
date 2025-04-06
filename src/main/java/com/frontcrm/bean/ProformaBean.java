package com.frontcrm.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.frontcrm.dto.ProformaCabDTO;
import com.frontcrm.dto.ProformaDTO;
import com.frontcrm.dto.ProformaDetDTO;
import com.frontcrm.service.ProfromaService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named("proformaBean")
@SessionScoped
public class ProformaBean  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private List<ProformaCabDTO> listaProformas;
	private List<ProformaDetDTO> detalleSeleccionado;
	private ProformaCabDTO proformaSeleccionada;
	
	@Inject
	private ProfromaService profromaService;
	
    @PostConstruct
    public void init() {
        try {
            this.listaProformas = profromaService.getAll();          
        } catch (Exception e) {
            this.listaProformas = new ArrayList<>(); 
        }
    }
	
	public void verDetalle(ProformaCabDTO proforma) {
		ProformaDTO res =new ProformaDTO();
		proforma.setEstado("Activo");
		res.setProformaCabDTO(proforma);
	    this.detalleSeleccionado = profromaService.getDetalles(res);
	}

	public void irNuevaProforma() {
	    try {
	        FacesContext.getCurrentInstance().getExternalContext()
	            .redirect("crearProforma.xhtml");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
