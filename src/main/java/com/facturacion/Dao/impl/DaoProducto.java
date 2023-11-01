package com.facturacion.Dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoProducto;
import com.facturacion.Entity.Productos;

@Repository
@Transactional
public class DaoProducto implements IDaoProducto {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Productos> findAll() {
        try {
            List<Productos> listaProductos = em.createQuery("FROM Productos", Productos.class).getResultList();
            return listaProductos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Transactional(readOnly = true)
    @Override
    public Productos findById(int id) {
        try {
            Productos producto= em.find(Productos.class,id);
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Productos save(Productos producto ) {
        try {
            em.persist(producto);
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Productos update(Productos producto) {
        try {
            em.merge(producto);
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

