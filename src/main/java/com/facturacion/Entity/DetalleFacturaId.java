package com.facturacion.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class DetalleFacturaId implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id_factura;
    private int id_producto;


    public DetalleFacturaId() {
	}

    public DetalleFacturaId(int idFactura, int idProducto) {
    	this.id_factura = idFactura;
        this.id_producto = idProducto;

	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       DetalleFacturaId that = (DetalleFacturaId) o;
        return Objects.equals(id_factura, that.id_factura) &&
               Objects.equals(id_producto, that.id_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_factura, id_producto);
    }

}