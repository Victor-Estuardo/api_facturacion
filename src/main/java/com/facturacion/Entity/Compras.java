package com.facturacion.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "compra")
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra") 
    private int id_compra;

    private int id_producto;

    private int id_proveedor;
    
    private int cantidad;

    private float precio_compra;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_crear;

    private String usuario_crear;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_mod;

    private String usuario_mod;

    private String estado;
    
    
}
	
	

