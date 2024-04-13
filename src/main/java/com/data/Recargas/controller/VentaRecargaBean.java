
package com.data.Recargas.controller;

import com.data.Recargas.model.Operador;
import com.data.Recargas.model.Persona;
import com.data.Recargas.model.VentaRecarga;
import com.data.Recargas.model.VentaRecargaDTO;
import com.data.Recargas.service.VentaRecargaService;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named("ventaRecargaBean")
@RequestScoped
public class VentaRecargaBean {
    
    Logger log = LogManager.getRootLogger();
    
    @Inject
    private VentaRecargaService ventaRecargaService;

    private VentaRecarga nuevaVentaRecarga;
    private List<VentaRecarga> reportePorOperador;
    private List<VentaRecarga> reportePorPersona;
    private List<Operador> operadores;
    private List<Persona> personas;
    private Operador operadorSeleccionado;
    private Persona personaSeleccionada;
    
    // DTO para manejar la selección del operador en la vista
    private VentaRecargaDTO ventaRecargaDTO;
    
    public VentaRecargaBean() {        
        nuevaVentaRecarga = new VentaRecarga();
    }

    @PostConstruct
    public void init() {
        ventaRecargaDTO = new VentaRecargaDTO();
        cargarOperadores();
        operadores = ventaRecargaService.obtenerOperadores();
        personas = ventaRecargaService.obtenerPersonas();
        operadorSeleccionado = new Operador();
        personaSeleccionada = new Persona();
    }
    
    // Método para cargar los operadores disponibles
    public void cargarOperadores() {
        
    }


    public void registrarVentaRecarga() {
        // Validar que la cantidad y el valor sean mayores que cero
        if (ventaRecargaDTO.getNumeroRecarga() == null || 
                ventaRecargaDTO.getValor() <= 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error", "El numero de recarga y el valor deben ser mayores que cero.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }
                
        //Pasa la informacion que sera persistida de la venta de la recarga
        nuevaVentaRecarga.setValor(ventaRecargaDTO.getValor());
        nuevaVentaRecarga.setNumeroRecarga(ventaRecargaDTO.getNumeroRecarga());
        nuevaVentaRecarga.setIdPersona(ventaRecargaDTO.getIdPersona());
        nuevaVentaRecarga.setIdOperador(ventaRecargaDTO.getIdOperador());
        // Establecer la fecha actual
        nuevaVentaRecarga.setFecha(new Date());
        // Establecer la cantidad de recarga en 1
        nuevaVentaRecarga.setCantidad(1);

        // Registrar la venta de recarga
        ventaRecargaService.registrarVentaRecarga(nuevaVentaRecarga);
        
        // Limpiar los campos después de la venta exitosa
        ventaRecargaDTO = new VentaRecargaDTO();
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Éxito", "La venta de recarga se ha registrado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }   
    
    // Método para buscar las ventas por operador
    public void buscarVentasPorOperador() {
        if (operadorSeleccionado == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Por favor selecciona un operador.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }
        
        reportePorOperador = ventaRecargaService.generarReporteVentasPorOperador(operadorSeleccionado);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Éxito", "La búsqueda se ha realizado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void buscarVentasPorPersona() {
        if (personaSeleccionada == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Por favor selecciona una persona.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }
        
        // Llamar al servicio para obtener el reporte de ventas por persona
        reportePorPersona = ventaRecargaService.generarReporteVentasPorPersona(personaSeleccionada);
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Éxito", "La búsqueda se ha realizado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public VentaRecargaService getVentaRecargaService() {
        return ventaRecargaService;
    }

    public void setVentaRecargaService(VentaRecargaService ventaRecargaService) {
        this.ventaRecargaService = ventaRecargaService;
    }

    public VentaRecarga getNuevaVentaRecarga() {
        return nuevaVentaRecarga;
    }

    public void setNuevaVentaRecarga(VentaRecarga nuevaVentaRecarga) {
        this.nuevaVentaRecarga = nuevaVentaRecarga;
    }

    public List<VentaRecarga> getReportePorOperador() {
        return reportePorOperador;
    }

    public void setReportePorOperador(List<VentaRecarga> reportePorOperador) {
        this.reportePorOperador = reportePorOperador;
    }

    public List<VentaRecarga> getReportePorPersona() {
        return reportePorPersona;
    }

    public void setReportePorPersona(List<VentaRecarga> reportePorPersona) {
        this.reportePorPersona = reportePorPersona;
    }

    public List<Operador> getOperadores() {
        return operadores;
    }

    public void setOperadores(List<Operador> operadores) {
        this.operadores = operadores;
    }

    public Operador getOperadorSeleccionado() {
        return operadorSeleccionado;
    }

    public void setOperadorSeleccionado(Operador operadorSeleccionado) {
        this.operadorSeleccionado = operadorSeleccionado;
    }    

    public VentaRecargaDTO getVentaRecargaDTO() {
        return ventaRecargaDTO;
    }

    public void setVentaRecargaDTO(VentaRecargaDTO ventaRecargaDTO) {
        this.ventaRecargaDTO = ventaRecargaDTO;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }
    
}
