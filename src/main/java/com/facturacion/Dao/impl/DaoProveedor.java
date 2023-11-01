package com.facturacion.Dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoProveedor;
import com.facturacion.Entity.Proveedores;

@Repository
@Transactional
public class DaoProveedor implements IDaoProveedor {
	@PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
	@Override
	public List<Proveedores> findAll() {
    	try {
            List<Proveedores> listaProveedores = em.createQuery("FROM Proveedores", Proveedores.class).getResultList();
            return listaProveedores;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
    
    @Transactional(readOnly = true)
	@Override
	public Proveedores findById(int id) {
    	 try {
             Proveedores proveedor = em.find(Proveedores.class, id);
             return proveedor;
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
	}

	@Override
	public Proveedores save(Proveedores proveedor) {
		 try {
	            em.persist(proveedor);
	            return proveedor;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}

	@Override
	public Proveedores update(Proveedores proveedor) {
		try {
            em.merge(proveedor);
            return proveedor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

}
