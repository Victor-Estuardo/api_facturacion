package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.Compras;

public interface IDaoCompras {
	public List<Compras> findAll();
	public Compras findById(int id);
    public Compras save(Compras compra);
    public Compras update(Compras compra);
    public boolean delete(int id);
}
