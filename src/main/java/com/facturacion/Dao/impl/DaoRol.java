package com.facturacion.Dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoRol;
import com.facturacion.Entity.Roles;

@Repository
@Transactional
public class DaoRol implements IDaoRol {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Roles> findAll() {
        try {
            List<Roles> listaRoles = em.createQuery("FROM Roles", Roles.class).getResultList();
            return listaRoles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Roles save(Roles rol) {
        try {
            em.persist(rol);
            return rol;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Roles update(Roles rol) {
        try {
            em.merge(rol);
            return rol;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

