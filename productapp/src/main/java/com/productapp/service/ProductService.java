package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface ProductService {
	 public int addProduct(Product product);
	 public Product getProduct(int pid);
	 public List<Product> selectAll();
	public int updatePoduct(int pid);
	public int deleteProduct(int pid);
}
