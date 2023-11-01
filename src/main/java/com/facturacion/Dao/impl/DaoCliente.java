package com.facturacion.Dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.Dao.IDaoCliente;
import com.facturacion.Entity.Clientes;

@Repository
@Transactional
public class DaoCliente implements IDaoCliente {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Clientes> findAll() {
        try {
            List<Clientes> listaClientes = em.createQuery("FROM Clientes", Clientes.class).getResultList();
            return listaClientes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Clientes findById(int id) {
        try {
            Clientes cliente = em.find(Clientes.class, id);
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Clientes save(Clientes cliente) {
        try {
            em.persist(cliente);
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Clientes update(Clientes cliente) {
        try {
            em.merge(cliente);
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
