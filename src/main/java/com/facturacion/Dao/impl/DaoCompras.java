package com.facturacion.Dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoCompras;
import com.facturacion.Entity.Compras;


@Repository
@Transactional
public class DaoCompras implements IDaoCompras{
	@PersistenceContext
	private EntityManager em;
 

	@Transactional(readOnly = true)
	@Override
	public List<Compras> findAll() {
		 try {
	        List<Compras> listaCompras = em.createQuery("FROM Compras", Compras.class).getResultList();
	        return listaCompras;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@Transactional(readOnly = true)
	@Override
	public Compras findById(int id) {
	    try {
	        return em.find(Compras.class, id); 
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	@Override
	public Compras save(Compras compras) {
		try {
	        em.persist(compras);
	        return compras;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	@Override
	public Compras update(Compras compras) {
		try {
	        em.merge(compras);
	        return compras;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	

	@Override
	public boolean delete(int id) {
	    try {
	        Compras compraToDelete = em.find(Compras.class, id);
	        if (compraToDelete != null) {
	            em.remove(compraToDelete);
	            return true; 
	        } else {
	            return false; 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; 
	    }
	}
}
