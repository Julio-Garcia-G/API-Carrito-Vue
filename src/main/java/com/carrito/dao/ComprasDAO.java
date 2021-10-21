package com.carrito.dao;

import java.util.List;

import com.carrito.models.Compras;

public interface ComprasDAO {

	List<Compras> consultarCompras();
	Compras insertarCompra(Compras compra);

}
