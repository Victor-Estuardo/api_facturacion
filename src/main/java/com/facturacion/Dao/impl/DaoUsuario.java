package com.facturacion.Dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoUsuario;
import com.facturacion.Entity.Empleados;
import com.facturacion.Entity.Usuarios;

@Repository
@Transactional
public class DaoUsuario implements IDaoUsuario {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Usuarios> findAll() {
        try {
            List<Usuarios> listaUsuarios = em.createQuery("FROM Usuarios", Usuarios.class).getResultList();
            return listaUsuarios;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuarios save(Usuarios usuario) {
        try {
            em.persist(usuario);
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuarios update(Usuarios usuario) {
        try {
            em.merge(usuario);
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Usuarios findByUser(String usuario) {
        try {
            TypedQuery<Usuarios> tq = em.createQuery("SELECT u FROM Usuarios u WHERE u.usuario = :usuario",Usuarios.class);
            Usuarios Usuario = tq.setParameter("usuario", usuario).getSingleResult();
            return Usuario;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Empleados findEmpleadoByName(String nombre) {
        try {
            TypedQuery<Empleados> query = em.createQuery("FROM Empleados e WHERE e.nombre = :nombre", Empleados.class);
            query.setParameter("nombre", nombre);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


}
