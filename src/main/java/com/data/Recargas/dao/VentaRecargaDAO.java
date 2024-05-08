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
 * Proporciona métodos para realizar operaciones CRUD
 * (Crear, Leer, Actualizar, Eliminar) relacionadas con las ventas y recargas.
 */
public interface VentaRecargaDAO {
    
    /**
     * Inserta una nueva venta o recarga en la base de datos.
     * @param ventaRecarga La venta o recarga a ser insertada.
     */
    void insertVentaRecarga(VentaRecarga ventaRecarga);
    
    /**
     * Obtiene todas las ventas o recargas realizadas por un operador específico.
     * @param operador El operador del cual se desean obtener las ventas o recargas.
     * @return Una lista de ventas o recargas realizadas por el operador especificado.
     */
    List<VentaRecarga> getVentasPorOperador(Operador operador);
    
    /**
     * Obtiene todas las ventas o recargas realizadas por una persona específica.
     * @param persona La persona de la cual se desean obtener las ventas o recargas.
     * @return Una lista de ventas o recargas realizadas por la persona especificada.
     */
    List<VentaRecarga> getVentasPorPersona(Persona persona);
    
    List<Operador> obtenerOperadores();
    
    List<Persona> obtenerPersonas();
}
