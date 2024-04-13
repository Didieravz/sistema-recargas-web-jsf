package com.data.Recargas.service;

import com.data.Recargas.model.Operador;
import com.data.Recargas.model.Persona;
import com.data.Recargas.model.VentaRecarga;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface VentaRecargaService {
    
    // Método para registrar una nueva venta de recarga
    void registrarVentaRecarga(VentaRecarga ventaRecarga);
    
    // Método para generar un reporte de ventas por operador
    List<VentaRecarga> generarReporteVentasPorOperador(Operador operador);
    
    // Método para generar un reporte de ventas por persona
    List<VentaRecarga> generarReporteVentasPorPersona(Persona persona);
    
    //Carga el listado de operadores
    List<Operador> obtenerOperadores();
    
    //Carga el listado de Personas (vendedore)
    List<Persona> obtenerPersonas();
    
}
