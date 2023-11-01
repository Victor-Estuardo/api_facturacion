package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.Categorias;

public interface IDaoCategoria {
    public List<Categorias> findAll();
    public Categorias save(Categorias categoria);
    public Categorias update(Categorias categoria);
}