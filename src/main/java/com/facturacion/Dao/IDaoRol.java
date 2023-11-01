package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.Roles;

public interface IDaoRol {
    public List<Roles> findAll();
    public Roles save(Roles rol);
    public Roles update(Roles rol);
}