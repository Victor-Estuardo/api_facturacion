package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.Productos;

public interface IDaoProducto {
    public List<Productos> findAll();
    public Productos findById(int id);
    public Productos save(Productos producto);
    public Productos update(Productos producto);
}