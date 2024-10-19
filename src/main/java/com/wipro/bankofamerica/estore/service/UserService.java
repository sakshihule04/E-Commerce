package com.wipro.bankofamerica.estore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.bankofamerica.estore.model.User;

@Service
public interface UserService {

	public User loginUser(String username, String password);
	
    public User saveUser(User user);

    public List<User> getAllUser();

    public List<User> getListByCity(String city);

    public User getUserByUserName(String username);

}
