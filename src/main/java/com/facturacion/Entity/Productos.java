package com.facturacion.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;
    private int id_categoria;
     @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", insertable = false, updatable = false)
     @JsonIgnoreProperties({"id_categoria"})
    private Categorias categoria;
    private String producto;
    private int existencia;
    @Temporal(TemporalType.DATE)
    private Date fecha_crear;
    private String usuario_crear;
    @Temporal(TemporalType.DATE)
    private Date fecha_mod;
    private String usuario_mod;
    private String estado;

}
