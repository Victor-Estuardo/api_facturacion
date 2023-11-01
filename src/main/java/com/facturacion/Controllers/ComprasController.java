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

import com.facturacion.Dao.IDaoCompras;
import com.facturacion.Entity.Compras;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = ("/facturador"))
public class ComprasController {

	@Autowired
    private IDaoCompras daoCompras;
	
	@GetMapping(value = "/compras", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Compras> getCompras() {
		return daoCompras.findAll();
	}
	
	@GetMapping(value = "/compras/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Compras> getCompraById(@PathVariable int id) {
		Compras compra = daoCompras.findById(id);
		if (compra != null) {
			return ResponseEntity.ok(compra);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value = "/compras", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Compras saveCompras(@RequestBody Compras compras) {
		return daoCompras.save(compras);
		
	}
	
	@PutMapping(value = "/compras", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Compras update(@RequestBody Compras compra){
		return daoCompras.update(compra);
	}
	
	@DeleteMapping(value = "compras/{id}")
	public ResponseEntity<String> deleteCompra(@PathVariable int id) {
	    boolean deleted = daoCompras.delete(id);

	    if (deleted) {
	        return new ResponseEntity<>("Compra eliminada exitosamente", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Compra no encontrada", HttpStatus.NOT_FOUND);
	    }
	}
}
