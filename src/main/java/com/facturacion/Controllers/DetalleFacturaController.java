package com.facturacion.Controllers;

import com.facturacion.Dao.IDaoDetalleFactura;
import com.facturacion.Entity.DetalleFactura;
import com.facturacion.Entity.DetalleFacturaId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/facturador")
public class DetalleFacturaController {

    @Autowired
    private IDaoDetalleFactura daoDetalleFactura;

    @GetMapping(value = "/detalleFactura", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DetalleFactura> getDetalleFactura() {
        return daoDetalleFactura.findAll();
    }
    
    @GetMapping("/detalleFactura/{idFactura}/{idProducto}")
    public DetalleFactura findById(@PathVariable int idFactura, @PathVariable int idProducto) {
        DetalleFacturaId id = new DetalleFacturaId(idFactura, idProducto);
        return daoDetalleFactura.findById(id);
    }
    
    @PostMapping(value = "/detalleFactura", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DetalleFactura saveDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
        return daoDetalleFactura.save(detalleFactura);
    }

    @PutMapping(value = "/detalleFactura", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DetalleFactura updateDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
        return daoDetalleFactura.update(detalleFactura);
    }
     
}
