package com.facturacion.Controllers;

import com.facturacion.Dao.IDaoDetalleFactura;
import com.facturacion.Entity.Clientes;
import com.facturacion.Entity.DetalleFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = ("/facturador"))
public class DetalleFacturaController {

    @Autowired
    private IDaoDetalleFactura daoDetalleFactura;

    @GetMapping(value = "/detalleFactura", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DetalleFactura> getDetalleFactura() {
        return daoDetalleFactura.findAll();
    }
    
    
    @GetMapping(value = "/detalle/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DetalleFactura>> getDetalleById(@PathVariable int id) {
        List<DetalleFactura> detalle = daoDetalleFactura.findById(id);
        if (!detalle.isEmpty()) {
            return ResponseEntity.ok(detalle);
        } else {
            return ResponseEntity.notFound().build();
        }
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
