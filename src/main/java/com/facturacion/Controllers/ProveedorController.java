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

import com.facturacion.Dao.IDaoProveedor;
import com.facturacion.Entity.Proveedores;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = ("/facturador"))
public class ProveedorController {
	@Autowired
    private IDaoProveedor daoProveedores;

    @GetMapping(value = "/proveedores", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Proveedores> getProveedores() {
		return daoProveedores.findAll();
	}

	@GetMapping(value = "/proveedores/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proveedores> getProveedorById(@PathVariable int id) {
		Proveedores proveedor = daoProveedores.findById(id);
		if (proveedor != null) {
			return ResponseEntity.ok(proveedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value = "/proveedores", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Proveedores saveProveedor(@RequestBody Proveedores proveedor) {
		return daoProveedores.save(proveedor);
	}

	@PutMapping(value = "/proveedores", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Proveedores update(@RequestBody Proveedores proveedor){
		return daoProveedores.update(proveedor);
	}
}
