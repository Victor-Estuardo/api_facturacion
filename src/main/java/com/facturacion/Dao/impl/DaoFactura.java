package com.facturacion.Dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoFactura;
import com.facturacion.Entity.Factura;

@Repository
@Transactional
public class DaoFactura implements IDaoFactura{

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional(readOnly = true)
	@Override
	public List<Factura> findAll() {
	    try {
	        List<Factura> listaFactura = em.createQuery("FROM Factura", Factura.class).getResultList();
	        return listaFactura;
	    } catch (Exception e) {
	        return null;
	    }
	}


	@Override
	public Factura findById(int id) {
		try {
	        Factura factura = em.find(Factura.class, id);
	        return factura;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	@Override
	public boolean delete(int id) {
		try {
	        Factura compraEliminar = em.find(Factura.class, id);
	        if (compraEliminar != null) {
	            em.remove(compraEliminar);
	            return true; 
	        } else {
	            return false; 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; 
	    }
	}


	@Override
	public Factura save(Factura factura) {
		try {
	        em.persist(factura);
	        return factura;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	@Override
    public Factura update(Factura factura) {
        try {
            em.merge(factura);
            return factura;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


	
}
