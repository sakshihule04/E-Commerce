package com.wipro.bankofamerica.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bankofamerica.estore.model.User;
import com.wipro.bankofamerica.estore.repository.UserRepository;
import com.wipro.bankofamerica.estore.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	
	 @Autowired
	    private UserRepository userRepo;


	    @Override
	    public User loginUser(String username, String password) {
	        return userRepo.findByUsername(username)
	                .filter(user -> user.getPassword().equals(password))
	                .orElseThrow(() ->new RuntimeException("Invalid username or password"));
	    }

	    @Override
	    public User saveUser(User user) { 		
	    	return 	userRepo.save(user);
	    }
	        		    

	    @Override
	    public List<User> getAllUser() { // Rename to getAllUsers
	        return userRepo.findAll(); // No parameter needed
	    }


	    @Override
	    public List<User> getListByCity(String city) {
	        return userRepo.findByCity(city);
	    }

	    @Override
	    public User getUserByUserName(String username) {
	    	
	        return userRepo.findByUsername(username)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	    }


}
