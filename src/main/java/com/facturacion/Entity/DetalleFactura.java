package com.facturacion.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "detalle_factura")
@IdClass(DetalleFacturaId.class)
public class DetalleFactura {

	@Id
    private int  id_factura;
	
	@Id
    private int  id_producto;
	
    private String cantidad;

    private float precio;

}