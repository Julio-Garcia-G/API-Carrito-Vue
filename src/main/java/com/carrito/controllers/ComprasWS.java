package com.carrito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.models.Compras;
import com.carrito.services.ComprasService;


@RestController
@RequestMapping("/api/v1/compras")
@CrossOrigin("*")
public class ComprasWS {

	@Autowired
	ComprasService servicio;
	
	@GetMapping()
	public ResponseEntity<?> consultarCompras(){
		List<Compras> resultado = null;
		try {
			resultado = servicio.consultarCompras();
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Compras>>(resultado, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> insertarCompra(@RequestBody Compras compra) {
		Compras resultado = null;
		//try {
			resultado = servicio.insertarCompra(compra);
		//} catch (DataAccessException e) {
			//return new ResponseEntity<>(HttpStatus.CONFLICT);
		//}
		
		return new ResponseEntity<Compras>(resultado, HttpStatus.CREATED);
	}
}
