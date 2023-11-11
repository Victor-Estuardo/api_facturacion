package com.facturacion.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoDetalleFactura;
import com.facturacion.Entity.DetalleFactura;
import com.facturacion.Entity.Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
	public List<DetalleFactura> findById(int id) {
    	try {
            TypedQuery<DetalleFactura> tq = em.createQuery("SELECT d FROM DetalleFactura d WHERE d.id_factura = :id",DetalleFactura.class);
            List<DetalleFactura> detalle = tq.setParameter("id", id).getResultList();
            return detalle;
        } catch (NoResultException e) {
            return null;
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
