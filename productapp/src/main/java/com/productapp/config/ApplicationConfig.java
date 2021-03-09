package com.productapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.productapp.dao.ProductDao;
import com.productapp.dao.impl.ProductDaoImpl;

@Configuration
public class ApplicationConfig {

	@Bean
	public ProductDao productDao() {
		return new ProductDaoImpl();
	}
}
