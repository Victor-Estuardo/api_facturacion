package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.DetalleFactura;

public interface IDaoDetalleFactura {
	
	public List<DetalleFactura> findAll();
	public DetalleFactura findById(int id);
	public DetalleFactura save(DetalleFactura detalleFactura);
    public DetalleFactura update(DetalleFactura detalleFactura);
    
}

