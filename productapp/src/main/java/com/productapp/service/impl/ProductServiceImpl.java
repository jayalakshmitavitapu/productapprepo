package com.productapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.ProductDao;
import com.productapp.model.Product;
import com.productapp.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductDao productDao;
	@Override
	public int addProduct(Product product) {
		return productDao.addProduct(product);
		 
	}
	@Override
	public Product getProduct(int pid) {
	
		return productDao.getProduct(pid);
	}
	@Override
	public List<Product> selectAll() {
		return productDao.selectAll();
	}

	@Override
	public int deleteProduct(int pid) {
		return productDao.deleteProduct(pid);
	}
	@Override
	public int updatePoduct(int pid) {
		return productDao.updatePoduct(pid);
	
	}

}
