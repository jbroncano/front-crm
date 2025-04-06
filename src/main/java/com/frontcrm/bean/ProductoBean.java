package com.frontcrm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.PrimeFaces;

import com.frontcrm.dto.AdmiProductoDTO;
import com.frontcrm.service.ProductoService;


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
@Named("productoBean")
@SessionScoped
public class ProductoBean  implements Serializable{
	   private static final long serialVersionUID = 1L;

	    private List<AdmiProductoDTO> productos;

	    private AdmiProductoDTO selectedProducto;

	    private List<AdmiProductoDTO> selectedProducts;
	    
	    @Inject
	    private ProductoService productoService;
	    
	    public ProductoBean() {
	    }
	    
	    @PostConstruct
	    public void init() {
	        try {
	            this.productos = productoService.getAll();          
	            this.selectedProducts = new ArrayList<>();
	        } catch (Exception e) {
	            this.productos = new ArrayList<>(); 
	        }
	    }
	    
	    public void openNew() {
	        this.selectedProducto = new AdmiProductoDTO();
	    }
	    
	    public void saveRol() {
	        if (this.selectedProducto.getIdProducto() == null) {
	        	selectedProducto.setEstado("Activo");
	        	AdmiProductoDTO newRol = productoService.create(selectedProducto);
	        	 this.productos.add(newRol);
	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Nuevo"));
	        }
	        else {
	        	productoService.update(selectedProducto);
	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Actualizado"));
	        }

	        PrimeFaces.current().executeScript("PF('manageProducDialog').hide()");
	        PrimeFaces.current().ajax().update("form:messages", "form:dt-rols");
	    }
	    
	    public void deleteRol() {
	    	this.productos.remove(selectedProducto);
	    	selectedProducto.setEstado("Inactivo");
	    	productoService.update(selectedProducto);
	        this.selectedProducto = null;
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
	        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	    }
}
