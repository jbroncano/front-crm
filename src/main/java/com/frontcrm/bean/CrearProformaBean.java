package com.frontcrm.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.frontcrm.dto.AdmiProductoDTO;
import com.frontcrm.dto.InfoPersonaDTO;
import com.frontcrm.dto.ProformaCabDTO;
import com.frontcrm.dto.ProformaDTO;
import com.frontcrm.dto.ProformaDetDTO;
import com.frontcrm.service.ProductoService;
import com.frontcrm.service.ProfromaService;
import com.frontcrm.service.ProspectoService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Named("crearProformaBean")
@ViewScoped
public class CrearProformaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Inject
    private ProspectoService personaservice;
    
    @Inject
    private ProductoService productoService;
    
	@Inject
	private ProfromaService profromaService;

    private ProformaCabDTO proformaCab;
    private List<ProformaDetDTO> detalles;

    private List<InfoPersonaDTO> listaPersonas;
    private List<AdmiProductoDTO> listaProductos;

    @PostConstruct
    public void init() {
        cargarPersonas();
        cargarProductos();
        detalles=new ArrayList<ProformaDetDTO>();
        proformaCab=new ProformaCabDTO();
    }

    public void cargarPersonas() {
        this.listaPersonas = personaservice.getAll();    
    }

    public void cargarProductos() {
    	listaProductos=productoService.getAll(); 
    	
    }

    public void seleccionarPersona(InfoPersonaDTO persona) {
        proformaCab.setPersona(persona);
    }

    public void agregarProducto(AdmiProductoDTO producto) {
        ProformaDetDTO det = new ProformaDetDTO();
        det.setProducto(producto);
        det.setCantidad("1");
        det.setEstado("Activo");
        detalles.add(det);
    }

    public void eliminarDetalle(ProformaDetDTO detalle) {
        detalles.remove(detalle);
    }

    public void guardarProforma() throws IOException {
        ProformaDTO dto = new ProformaDTO();
        proformaCab.setEstado("Activo");
        dto.setProformaCabDTO(proformaCab);
        dto.setLstProformaDetDTO(detalles);
        profromaService.create(dto);
        FacesContext.getCurrentInstance().getExternalContext()
        .redirect("preformas.xhtml");
    }

}
