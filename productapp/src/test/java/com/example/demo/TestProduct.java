package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.productapp.Application;
import com.productapp.dao.ProductDao;
import com.productapp.model.Product;

@SpringBootTest(classes = TestProduct.class)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Product Test Cases")
@ContextConfiguration(classes = Application.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestProduct {

	
	int expected;
	
	@Autowired
	private  ProductDao productDao;
	
	private Product product;
	
	private int expectednum[]= {10,20,30};
	
	@BeforeAll
	public void setup() {
		 expected = 30;
	}
	
	@Test
	public void testAddition() {
		 int actual = 10+20;
		 Assertions.assertEquals(expected, actual);
	}
	
	@Test 
	public void testArray() {
		 int acutalnum[] = {10,20,30,40};
		 Assertions.assertArrayEquals(expectednum,acutalnum);
	}
	
	
	@Test
	@Order(1)
	@DisplayName("It is test case for saving the product")
	@RepeatedTest(2)
	public void testSaveProduct() {
		System.out.println("testSaveProduct method....");
	}
	@Test
	@Order(2)
	public void testDeleteProduct() {
		System.out.println("testDeleteProduct method....");
	}
	@Test
	@Order(3)
	public void testUpdateProduct() {
		System.out.println("testUpdateProduct method....");
	}
	@Test
	@Order(4)
	public void testSelectProduct() {
		product = productDao.getProduct(7);
		System.out.println(product.getPid()+" "+product.getPname()+" "+product.getPcost());
		Assertions.assertNotNull(product);
		
	}
	@AfterAll
	public void clear() {
		expected=0;
		product = null;
		productDao = null;
		
	}


}
