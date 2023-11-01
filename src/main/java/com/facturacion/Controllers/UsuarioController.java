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

import com.facturacion.Dao.IDaoUsuario;
import com.facturacion.Entity.Empleados;
import com.facturacion.Entity.Usuarios;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = ("/facturador"))
public class UsuarioController {

	@Autowired
	private IDaoUsuario daoUsuarios;

	@GetMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuarios> getUsuarios() {
		return daoUsuarios.findAll();
	}

	@GetMapping(value = "/usuarios/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuarios> getUsuarioById(@PathVariable String usuario) {
		Usuarios Usuario = daoUsuarios.findByUser(usuario);
		if (Usuario != null) {
			return ResponseEntity.ok(Usuario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(value = "usuarios/empleados/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empleados> findEmpleadoByName(@PathVariable String nombre) {
		Empleados empleado = daoUsuarios.findEmpleadoByName(nombre);
		if (empleado != null) {
			return ResponseEntity.ok(empleado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuarios saveUsuario(@RequestBody Usuarios usuario) {
		return daoUsuarios.save(usuario);
	}

	@PutMapping(value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuarios update(@RequestBody Usuarios usuario) {
		return daoUsuarios.update(usuario);
	}
}
