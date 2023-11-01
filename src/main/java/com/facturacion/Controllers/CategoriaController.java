package com.facturacion.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.Dao.IDaoCategoria;
import com.facturacion.Entity.Categorias;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = ("/facturador"))
public class CategoriaController {

    @Autowired
    private IDaoCategoria daoCategorias;

    @GetMapping(value = "/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Categorias> getCategorias() {
		return daoCategorias.findAll();
	}

	@PostMapping(value = "/categorias", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Categorias saveCategoria(@RequestBody Categorias categoria) {
		return daoCategorias.save(categoria);
	}

	@PutMapping(value = "/categorias", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Categorias update(@RequestBody Categorias categoria){
		return daoCategorias.update(categoria);
	}
}
