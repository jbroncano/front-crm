package com.frontcrm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.PrimeFaces;

import com.frontcrm.dto.AdmiRolDTO;
import com.frontcrm.service.RolService;

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
@Named("rolBean")
@SessionScoped
public class RolBean  implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<AdmiRolDTO> rols;

    private AdmiRolDTO selectedRol;

    private List<AdmiRolDTO> selectedRols;
    
    @Inject
    private RolService rolService;
    
    public RolBean() {
    }
    
    @PostConstruct
    public void init() {
        try {
            this.rols = rolService.getAll();          
            this.selectedRols = new ArrayList<>();
        } catch (Exception e) {
            this.rols = new ArrayList<>(); 
        }
    }
    
    public void openNew() {
        this.selectedRol = new AdmiRolDTO();
    }
    
    public void saveRol() {
        if (this.selectedRol.getIdRol() == null) {
        	selectedRol.setEstado("Activo");
        	AdmiRolDTO newRol = rolService.create(selectedRol);
        	 this.rols.add(newRol);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rol Agregado"));
        }
        else {
        	rolService.update(selectedRol);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rol Actualizado"));
        }

        PrimeFaces.current().executeScript("PF('manageRolDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-rols");
    }
    
    public void deleteRol() {
    	this.rols.remove(selectedRol);
    	selectedRol.setEstado("Inactivo");
    	rolService.update(selectedRol);
        this.selectedRol = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rol Eliminado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-rols");
    }
    
}
