package com.facturacion.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.Dao.IDaoProducto;
import com.facturacion.Entity.Productos;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = ("/facturador"))
public class ProductoController {

    @Autowired
    private IDaoProducto daoProductos;

    @GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Productos> getProductos() {
		return daoProductos.findAll();
	}
    
    @GetMapping(value = "/productos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productos> findById(@PathVariable int id) {
		Productos producto = daoProductos.findById(id);
		if (producto != null) {
			return ResponseEntity.ok(producto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
    
	@PostMapping(value = "/productos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Productos saveProducto(@RequestBody Productos producto) {
		return daoProductos.save(producto);
	}
	
	@PutMapping(value = "/productos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Productos update(@RequestBody Productos producto){
		return daoProductos.update(producto);
	}

	
}
