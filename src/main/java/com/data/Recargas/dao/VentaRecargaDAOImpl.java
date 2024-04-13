package com.data.Recargas.dao;

import com.data.Recargas.model.Operador;
import com.data.Recargas.model.Persona;
import com.data.Recargas.model.VentaRecarga;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author usuario
 */
public class VentaRecargaDAOImpl implements VentaRecargaDAO{
    
     @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertVentaRecarga(VentaRecarga ventaRecarga) {
        entityManager.persist(ventaRecarga);
    }

    @Override
    public List<VentaRecarga> getVentasPorOperador(Operador operador) {
        return entityManager.createQuery("SELECT v FROM VentaRecarga v WHERE v.idOperador = :idOperador", VentaRecarga.class)
                            .setParameter("idOperador", operador.getIdOperador())
                            .getResultList();
    }

    @Override
    public List<VentaRecarga> getVentasPorPersona(Persona persona) {
        return entityManager.createQuery("SELECT v FROM VentaRecarga v WHERE v.idPersona = :idPersona", VentaRecarga.class)
                            .setParameter("idPersona", persona.getIdPersona())
                            .getResultList();
    }
    
    @Override
    public List<Operador> obtenerOperadores() {
        return entityManager.createQuery("SELECT o FROM Operador o", Operador.class).getResultList();
    }
    
    @Override
    public List<Persona> obtenerPersonas() {
        return entityManager.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
    }
    
}
