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
	    public ApiResponse<List<Product>> getAllProducts() {
	        List<Product> products = productRepository.findAll();
	        return new ApiResponse<>("success", "Products retrieved successfully.", products);
	    }

	    @Override
	    public ApiResponse<Product> saveProduct(Product product) {
	        Product savedProduct = productRepository.save(product);
	        return new ApiResponse<>("success", "Product saved successfully.", savedProduct);
	    }

	    @Override
	    public ApiResponse<Product> getProductById(Integer id) {
	        Optional<Product> product = productRepository.findById(id);
	        return product.map(p -> new ApiResponse<>("success", "Product retrieved successfully.", p))
	                      .orElseGet(() -> new ApiResponse<>("error", "Product not found.", null));
	    }

	    @Override
	    public ApiResponse<Void> deleteProduct(Integer id) {
	        if (productRepository.existsById(id)) {
	            productRepository.deleteById(id);
	            return new ApiResponse<>("success", "Product deleted successfully.", null);
	        } else {
	            return new ApiResponse<>("error", "Product not found.", null);
	        }
	    }

	    @Override
	    public ApiResponse<Product> updateProduct(Integer id, Product productDetails) {
	        Optional<Product> existingProductOpt = productRepository.findById(id);
	        if (existingProductOpt.isPresent()) {
	            Product existingProduct = existingProductOpt.get();
	            // Update fields
	            existingProduct.setProductId(productDetails.getProductId());
	            existingProduct.setProductName(productDetails.getProductName());
	            existingProduct.setProductDescription(productDetails.getProductDescription());
	            existingProduct.setQuantity(productDetails.getQuantity());
	            existingProduct.setAmount(productDetails.getAmount());
	            existingProduct.setStatus(productDetails.getStatus());
	            Product updatedProduct = productRepository.save(existingProduct);
	            return new ApiResponse<>("success", "Product updated successfully.", updatedProduct);
	        } else {
	            return new ApiResponse<>("error", "Product not found.", null);
	        }
	    }
}
