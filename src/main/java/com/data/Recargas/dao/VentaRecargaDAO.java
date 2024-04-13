/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.data.Recargas.dao;

import com.data.Recargas.model.Operador;
import com.data.Recargas.model.Persona;
import com.data.Recargas.model.VentaRecarga;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface VentaRecargaDAO {
    
    void insertVentaRecarga(VentaRecarga ventaRecarga);
    
    List<VentaRecarga> getVentasPorOperador(Operador operador);
    
    List<VentaRecarga> getVentasPorPersona(Persona persona);
    
    List<Operador> obtenerOperadores();
    
    List<Persona> obtenerPersonas();
}
