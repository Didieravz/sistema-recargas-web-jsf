
package com.data.Recargas.controller;

import com.data.Recargas.model.Operador;
import com.data.Recargas.model.Persona;
import com.data.Recargas.model.VentaRecarga;
import com.data.Recargas.service.VentaRecargaService;
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

    private VentaRecarga nuevaVentaRecarga = new VentaRecarga();;
    private List<VentaRecarga> reportePorOperador;
    private List<VentaRecarga> reportePorPersona;
    private List<Operador> operadores;

    @PostConstruct
    public void init() {
        log.debug("Iniciando el objeto PersonaBean");
        cargarOperadores();
    }
    
    // Método para cargar los operadores disponibles
    public void cargarOperadores() {
        operadores = ventaRecargaService.obtenerOperadores();
    }


    public void registrarVentaRecarga() {
        // Validar que la cantidad y el valor sean mayores que cero
        if (nuevaVentaRecarga.getNumeroRecarga() <= 0 || nuevaVentaRecarga.getValor() <= 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error", "El numero de recarga y el valor deben ser mayores que cero.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }

        // Registrar la venta de recarga
        ventaRecargaService.registrarVentaRecarga(nuevaVentaRecarga);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Éxito", "La venta de recarga se ha registrado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);

        // Limpiar los campos después de la venta
        nuevaVentaRecarga = new VentaRecarga();
    }

    public void generarReporteVentasPorOperador(Operador operador) {
        reportePorOperador = ventaRecargaService.generarReporteVentasPorOperador(operador);
    }

    public void generarReporteVentasPorPersona(Persona persona) {
        reportePorPersona = ventaRecargaService.generarReporteVentasPorPersona(persona);
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

    
}
