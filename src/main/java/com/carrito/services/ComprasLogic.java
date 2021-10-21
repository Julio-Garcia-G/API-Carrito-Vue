package com.carrito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.dao.ComprasDAO;
import com.carrito.models.Compras;

@Service
public class ComprasLogic implements ComprasService {

	@Autowired
	ComprasDAO repositorio;
	
	@Override
	public List<Compras> consultarCompras() {
		return repositorio.consultarCompras();
	}
	
	@Override
	public Compras insertarCompra(Compras compra) {		
		return repositorio.insertarCompra(compra);
	}

}
