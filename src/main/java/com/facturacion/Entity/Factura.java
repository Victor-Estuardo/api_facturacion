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
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    public int id_factura;
    public String referencia;
    public int id_cliente;
    public String fecha;
    public String serie;
    public String numero;
    public String authorization;
    @Temporal(TemporalType.DATE)
    public Date fecha_crear;
    public String usuario_crear;
    @Temporal(TemporalType.DATE)
    public Date fecha_mod;
    public String usuario_mod;
    public String estado;

    

    
}
