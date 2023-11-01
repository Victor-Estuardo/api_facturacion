package com.facturacion.Dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoCategoria;
import com.facturacion.Entity.Categorias;

@Repository
@Transactional
public class DaoCategoria implements IDaoCategoria {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Categorias> findAll() {
        try {
            List<Categorias> listaCategorias = em.createQuery("FROM Categorias", Categorias.class).getResultList();
            return listaCategorias;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Categorias save(Categorias categoria) {
        try {
            em.persist(categoria);
            return categoria;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Categorias update(Categorias categoria) {
        try {
            em.merge(categoria);
            return categoria;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

