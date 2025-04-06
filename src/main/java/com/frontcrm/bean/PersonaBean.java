package com.frontcrm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.PrimeFaces;

import com.frontcrm.dto.InfoPersonaDTO;
import com.frontcrm.service.ProspectoService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named("personaBean")
@SessionScoped
public class PersonaBean  implements Serializable{
	   private static final long serialVersionUID = 1L;

	    private List<InfoPersonaDTO> personas;

	    private InfoPersonaDTO selectedPersona;

	    private List<InfoPersonaDTO> selectedPersonas;
	    
	    @Inject
	    private ProspectoService personaservice;
	    
	    public PersonaBean() {
	    }
	    
	    @PostConstruct
	    public void init() {
	        try {
	            this.personas = personaservice.getAll();          
	            this.selectedPersonas = new ArrayList<>();
	        } catch (Exception e) {
	            this.personas = new ArrayList<>(); 
	        }
	    }
	    
	    public void openNew() {
	        this.selectedPersona = new InfoPersonaDTO();
	    }
	    
	    public void savePersona() {
	        if (this.selectedPersona.getIdPersona() == null) {
	        	selectedPersona.setEstado("Activo");
	        	InfoPersonaDTO newRol = personaservice.create(selectedPersona);
	        	 this.personas.add(newRol);
	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Persona Agregado"));
	        }
	        else {
	        	personaservice.update(selectedPersona);
	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Persona Actualizado"));
	        }

	        PrimeFaces.current().executeScript("PF('manageProductoDialog').hide()");
	        PrimeFaces.current().ajax().update("form:messages", "form:dt-personas");
	    }
	    
	    public void deletePersona() {
	    	this.personas.remove(selectedPersona);
	    	selectedPersona.setEstado("Inactivo");
	    	personaservice.update(selectedPersona);
	        this.selectedPersona = null;
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Persona Eliminada"));
	        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	    }
}
