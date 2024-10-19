package com.wipro.bankofamerica.estore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bankofamerica.estore.model.Product;
import com.wipro.bankofamerica.estore.repository.ProductRepository;
import com.wipro.bankofamerica.estore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	 @Autowired
	    private ProductRepository productRepository;

	    @Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    @Override
	    public Product saveProduct(Product product) {
	        return productRepository.save(product);
	    }

	    @Override
	    public Product getProductById(Integer id) {
	        Optional<Product> product = productRepository.findById(id);
	        return product.orElse(null);
	    }

	    @Override
	    public void deleteProduct(Integer id) {
	        productRepository.deleteById(id);
	    }


}
