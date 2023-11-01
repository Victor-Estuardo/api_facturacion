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

import com.facturacion.Dao.IDaoRol;
import com.facturacion.Entity.Roles;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = ("/facturador"))
public class RolController {

    @Autowired
    private IDaoRol daoRoles;

    @GetMapping(value = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Roles> getRoles() {
		return daoRoles.findAll();
	}

	@PostMapping(value = "/roles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Roles saveRol(@RequestBody Roles rol) {
		return daoRoles.save(rol);
	}

	@PutMapping(value = "/roles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Roles update(@RequestBody Roles rol){
		return daoRoles.update(rol);
	}
}
