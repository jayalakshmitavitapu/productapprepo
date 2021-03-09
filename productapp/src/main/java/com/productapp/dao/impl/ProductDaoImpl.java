package com.productapp.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.productapp.dao.ProductDao;
import com.productapp.model.Product;
import com.productapp.rowmapper.ProductRowMapper;
@Repository
public class ProductDaoImpl implements ProductDao{
@Autowired
JdbcTemplate jdbcTemplate;
	@Override
	public int addProduct(Product product) {
		int result=0;
		try {
		result=jdbcTemplate.update("insert into product (product_name,product_cost) values(?,?)",product.getPname(),product.getPcost());
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("result is "+result);
		return result;
	}
	@Override
	public Product getProduct(int pid) {
		try {
		Product p=jdbcTemplate.queryForObject("select product_id,product_name,product_cost from product where product_id=?",new ProductRowMapper(),pid);
		if(p!=null) {
			return p;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Product> selectAll() {
		
		List<Product> product=jdbcTemplate.query("select product_id,product_name,product_cost from product",new ProductRowMapper());
		return product;
	
	}
	@Override
	public int updatePoduct(int pid) {
		int result = jdbcTemplate.update("update product set product_name=?,product_cost=? where product_id=?");
		return result;
	}
	@Override
	public int deleteProduct(int pid) {
		int result=0;
		try {
		 result=jdbcTemplate.update("delete from product where product_id=?",pid);
			}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
