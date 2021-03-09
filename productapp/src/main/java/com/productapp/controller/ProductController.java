package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.exceptions.ProductNotFoundExeption;
import com.productapp.model.CustomResponse;
import com.productapp.model.Product;
import com.productapp.service.ProductService;


@RestController
@RequestMapping("/productcontroller")
public class ProductController {
	
@Autowired
private ProductService productService;

@RequestMapping(value="/insertproduct",method=RequestMethod.POST)
 public ResponseEntity<CustomResponse> AddProduct(@RequestBody Product product) {
	 int result=productService.addProduct(product);
	 CustomResponse cr=new CustomResponse();
	 if(result>0) {
		 cr.setCode(200);
		 cr.setStatus("inserted successfully");
		 return new ResponseEntity<CustomResponse>(cr,HttpStatus.OK);
	 }
	 else
     cr.setCode(400);
	 cr.setStatus("not inserted");
	 return new ResponseEntity<CustomResponse>(cr,HttpStatus.OK);
	 
 }

@RequestMapping(value="/getproduct/{id}",method=RequestMethod.GET)
public Product GetProduct(@PathVariable("id") int pid) throws ProductNotFoundExeption{
	Product p= productService.getProduct(pid);
	
      if(p==null) {
	throw new ProductNotFoundExeption();
}
	return p;
		
	
}
@RequestMapping(value="/selectall",method=RequestMethod.GET)
public List<Product> selectAllProducts(){
	List<Product> p=productService.selectAll();
	return p;
}
@RequestMapping(value="/updateproduct/{id}",method=RequestMethod.PUT)
public int updateProduct(@PathVariable("id") int pid ,Product product) {
	int result=productService.updatePoduct(pid);
	if(result>0) {
		
	}
	return 0;
}
@RequestMapping(value="/deleteproduct/{id}",method=RequestMethod.GET)
public ResponseEntity<CustomResponse> deleteProduct(@PathVariable("id") int pid) {
	
	int result=productService.deleteProduct(pid);
	System.out.println("result is"+result);
	CustomResponse cr=new CustomResponse();
		if(result>0) {
			cr.setCode(200);
			cr.setStatus("deleted successfully");
	     }
		else
			cr.setCode(400);
		    cr.setStatus("Not deleted");
	return new ResponseEntity<CustomResponse>(cr,HttpStatus.OK);
}

}
