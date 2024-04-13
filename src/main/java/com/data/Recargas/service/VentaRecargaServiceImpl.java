
package com.data.Recargas.service;

import com.data.Recargas.dao.VentaRecargaDAO;
import com.data.Recargas.model.Operador;
import com.data.Recargas.model.Persona;
import com.data.Recargas.model.VentaRecarga;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VentaRecargaServiceImpl implements VentaRecargaService{
    
    @Inject
    private VentaRecargaDAO ventaRecargaDAO;

    @Override
    public void registrarVentaRecarga(VentaRecarga ventaRecarga) {
        ventaRecargaDAO.insertVentaRecarga(ventaRecarga);
    }  

    @Override
    public List<VentaRecarga> generarReporteVentasPorOperador(Operador operador) {
        return ventaRecargaDAO.getVentasPorOperador(operador);
    }

    @Override
    public List<VentaRecarga> generarReporteVentasPorPersona(Persona persona) {
        return ventaRecargaDAO.getVentasPorPersona(persona);
    }
    
    @Override
    public List<Operador> obtenerOperadores() {
        return ventaRecargaDAO.obtenerOperadores();
    }
    
    @Override
    public List<Persona> obtenerPersonas() {
        return ventaRecargaDAO.obtenerPersonas();
    }
    
}
