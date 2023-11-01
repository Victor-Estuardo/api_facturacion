package com.facturacion.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.Dao.IDaoFactura;
import com.facturacion.Entity.Factura;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = ("/facturador"))
public class FacturaController {
	
	@Autowired
    private IDaoFactura daoFactura;

	@GetMapping(value = "/facturas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Factura> getFactura() {
		return daoFactura.findAll();
	}
	
	@GetMapping(value = "/facturas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Factura> getfacturaById(@PathVariable int id) {
		Factura factura = daoFactura.findById(id);
		if (factura != null) {
			return ResponseEntity.ok(factura);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value = "/facturas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Factura saveFactura(@RequestBody Factura factura) {
		return daoFactura.save(factura);
		
	}
	
	@PutMapping(value = "/facturas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Factura update(@RequestBody Factura factura){
		return daoFactura.update(factura);
	}
	
	
	@DeleteMapping(value = "/factura/{id}")
	public ResponseEntity<String> borrarFactura(@PathVariable int id) {
	    boolean deleted = daoFactura.delete(id);

	    if (deleted) {
	        return new ResponseEntity<>("Factura eliminada exitosamente", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Factura no encontrada", HttpStatus.NOT_FOUND);
	    }
	}
	
	
}
