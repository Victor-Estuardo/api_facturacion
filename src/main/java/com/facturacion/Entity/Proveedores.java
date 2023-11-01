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
@Table(name = "proveedor")
public class Proveedores {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
	private int id_proveedor;
	private String nombre;
	private String nit;
	private String direccion;
	private String telefono;
	@Temporal(TemporalType.DATE)
    private Date fecha_crear;
    private String usuario_crear;
    @Temporal(TemporalType.DATE)
    private Date fecha_mod;
    private String usuario_mod;
    private String estado; 
}
