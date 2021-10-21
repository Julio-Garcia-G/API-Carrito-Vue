package com.carrito.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.carrito.models.Compras;

@Repository
public class ComprasJDBC implements ComprasDAO {

	@Autowired
	JdbcTemplate conexion;	

	@Override
	public List<Compras> consultarCompras() {
		String sql_query = "SELECT * FROM compras";
		return conexion.query(sql_query, new RowMapper<Compras>() {
            public Compras mapRow(ResultSet rs, int rowNum) throws SQLException {
                Compras compra = new Compras();
                compra.setId(rs.getInt("id"));
                compra.setNombre(rs.getString("nombre"));
                compra.setCantidad(rs.getInt("cantidad"));
                compra.setPrecio(rs.getInt("precio"));
                compra.setSubtotal(rs.getInt("subtotal"));
                compra.setCompra_id(rs.getInt("COMPRA_id"));
                
                return compra;
            }
        });			
	}
	
	@Override
	public Compras insertarCompra(Compras compra) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(conexion)
				.withTableName("compras")
				.usingColumns("nombre","cantidad","precio","subtotal","compra_id")
				.usingGeneratedKeyColumns("id");
		
		Map<String,Object> datos = new HashMap<>();
		datos.put("nombre", compra.getNombre());
		datos.put("cantidad", compra.getCantidad());
		datos.put("precio", compra.getPrecio());
		datos.put("subtotal", compra.getCantidad() * compra.getPrecio());
		datos.put("compra_id", compra.getCompra_id());
		
		Number id = insert.executeAndReturnKey(datos);
		compra.setId(id.intValue());		
		
		return compra;
	}
	

}
