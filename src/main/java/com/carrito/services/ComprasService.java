package com.carrito.services;

import java.util.List;

import com.carrito.models.Compras;

public interface ComprasService {	

	List<Compras> consultarCompras();
	Compras insertarCompra(Compras compra);

}
