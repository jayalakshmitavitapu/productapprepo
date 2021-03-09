package com.productapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.productapp.model.Product;

public class ProductRowMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product=new Product();
		product.setPid(rs.getInt("product_id"));
		product.setPname(rs.getString("product_name"));
		product.setPcost(rs.getDouble("product_cost"));
		return product;
	}

}
