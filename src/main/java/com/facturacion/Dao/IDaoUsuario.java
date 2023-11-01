package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.Empleados;
import com.facturacion.Entity.Usuarios;

public interface IDaoUsuario {
    public List<Usuarios> findAll();
    public Usuarios findByUser (String usuario);
    public Usuarios save(Usuarios usuario);
    public Usuarios update(Usuarios usuario);
    public Empleados findEmpleadoByName(String nombre);
}