package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.Clientes;

public interface IDaoCliente {
    public List<Clientes> findAll();
    public Clientes findById(int id);
    public Clientes save(Clientes cliente);
    public Clientes update(Clientes cliente);
}