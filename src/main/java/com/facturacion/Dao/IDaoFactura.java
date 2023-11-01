package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.Factura;

public interface IDaoFactura {
	public List<Factura> findAll();
	public Factura findById(int id);
    public Factura save(Factura factura);
    public Factura update(Factura factura);
	public boolean delete(int id);
}
