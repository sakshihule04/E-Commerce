package com.wipro.bankofamerica.estore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.bankofamerica.estore.model.Product;
import com.wipro.bankofamerica.estore.service.impl.ApiResponse;

@Service
public interface ProductService {

	ApiResponse<List<Product>> getAllProducts();
	
    ApiResponse<Product> saveProduct(Product product);
    
    ApiResponse<Product> getProductById(Integer id);
    
    ApiResponse<Void> deleteProduct(Integer id);
    
    ApiResponse<Product> updateProduct(Integer id, Product product);
	    
}
