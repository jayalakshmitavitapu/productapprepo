package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.exceptions.ProductIdNotFoundExeption;
import com.productapp.exceptions.ProductsNotAvailableException;
import com.productapp.model.CustomResponse;
import com.productapp.model.Product;
import com.productapp.service.ProductService;

@RestController
@RequestMapping("/productapi")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/insertproduct")
	public ResponseEntity<CustomResponse> AddProduct(@RequestBody Product product) {
		int result = productService.addProduct(product);
		CustomResponse cr = new CustomResponse();
		if (result > 0) {
			cr.setCode(200);
			cr.setStatus("product inserted successfully");
			return new ResponseEntity<>(cr, HttpStatus.OK);
		} else {
			cr.setCode(417);
			cr.setStatus("product not inserted");
			return new ResponseEntity<>(cr, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@GetMapping(value = "/getproduct/{id}")
	public Product GetProduct(@PathVariable("id") int pid){
		Product p = productService.getProduct(pid);
		if (p == null) {
			throw new ProductIdNotFoundExeption("The given Product id not exist");
		}
		return p;

	}

	@GetMapping(value = "/selectall")
	public List<Product> selectAllProducts(){
		CustomResponse cr=new CustomResponse();
		List<Product> product = productService.selectAll();
		System.out.println("the product is"+product);
		if (product.isEmpty()) {
			System.out.println("ProductsNotAvailableException");
			throw new ProductsNotAvailableException("No Products Available");
		}
		return product;
	}

	@PutMapping(value = "/updateproduct/{id}")
	public ResponseEntity<CustomResponse> updateProduct(@PathVariable("id") int pid, @RequestBody Product product) {
		int result = productService.updateProduct(pid, product);
		System.out.println(result + "result");
		CustomResponse cr = new CustomResponse();
		if (result > 0) {
			cr.setCode(200);
			cr.setStatus("updated successfully");
		} else {
			cr.setCode(400);
			cr.setStatus("not updated");
		}
		return new ResponseEntity<>(cr, HttpStatus.EXPECTATION_FAILED);

	}

	@GetMapping(value = "/deleteproduct/{id}")
	public ResponseEntity<CustomResponse> deleteProduct(@PathVariable("id") int pid) {
		int result = productService.deleteProduct(pid);
		System.out.println("result is" + result);
		CustomResponse cr = new CustomResponse();
		if (result > 0) {
			cr.setCode(200);
			cr.setStatus("deleted successfully");
		} else
			throw new ProductIdNotFoundExeption("The Product id is not exist ");
		return new ResponseEntity<>(cr, HttpStatus.EXPECTATION_FAILED);
	}

}
