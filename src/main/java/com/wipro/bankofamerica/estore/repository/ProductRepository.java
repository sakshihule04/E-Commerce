package com.wipro.bankofamerica.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bankofamerica.estore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	

}
