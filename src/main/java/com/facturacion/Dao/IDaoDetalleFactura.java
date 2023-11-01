package com.facturacion.Dao;

import java.util.List;

import com.facturacion.Entity.DetalleFactura;
import com.facturacion.Entity.DetalleFacturaId;

public interface IDaoDetalleFactura {
	
	public List<DetalleFactura> findAll();
	public DetalleFactura findById(DetalleFacturaId id);
	public DetalleFactura save(DetalleFactura detalleFactura);
    public DetalleFactura update(DetalleFactura detalleFactura);
}
