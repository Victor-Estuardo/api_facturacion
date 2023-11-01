package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.Proveedores;


public interface IDaoProveedor {
	public List<Proveedores> findAll();
    public Proveedores findById(int id);
    public Proveedores save(Proveedores proveedor);
    public Proveedores update(Proveedores proveedor);
}
