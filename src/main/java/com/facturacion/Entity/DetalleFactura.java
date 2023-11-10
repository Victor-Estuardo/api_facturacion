package com.facturacion.Entity;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "detalle")
public class DetalleFactura {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id_factura")
    private int  id_factura;
	
    private int  id_producto;
	
    private String cantidad;

    private float precio;

}