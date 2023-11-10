package com.facturacion.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoDetalleFactura;
import com.facturacion.Entity.DetalleFactura;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class DaoDetalleFactura implements IDaoDetalleFactura {

	@Autowired
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<DetalleFactura> findAll() {
        try {
            List<DetalleFactura> listaDetalle = em.createQuery("FROM DetalleFactura", DetalleFactura.class).getResultList();
            return listaDetalle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Transactional(readOnly = true)
	@Override
	public DetalleFactura findById(int id) {
    	try {
            DetalleFactura detalleFactura = em.find(DetalleFactura.class, id);
            return detalleFactura;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
    
    
    @Override
    public DetalleFactura save(DetalleFactura detalleFactura) {
        try {
            em.persist(detalleFactura);
            return detalleFactura;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DetalleFactura update(DetalleFactura detalleFactura) {
        try {
            em.merge(detalleFactura);
            return detalleFactura;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	
}
