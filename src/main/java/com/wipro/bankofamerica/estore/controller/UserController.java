package com.wipro.bankofamerica.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bankofamerica.estore.model.LoginRequest;
import com.wipro.bankofamerica.estore.model.User;
import com.wipro.bankofamerica.estore.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

	 @Autowired
	    private UserService userService;

	    @PostMapping("/login")
	    public ResponseEntity<User> loginUser(@RequestBody Map<String, String> request){
	        String username = request.get("username");
	        String password = request.get("password");
	        User user = userService.loginUser(username, password);
	        return ResponseEntity.ok(user);

	    }

	    @PostMapping
	    public ResponseEntity<User> saveUser(@RequestBody User user) {
	        User savedUser = userService.saveUser(user);
	        return ResponseEntity.ok(savedUser);
	    }

	    @GetMapping
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> user = userService.getAllUser();
	        return ResponseEntity.ok(user);
	    }

	    @GetMapping("/city")
	    public ResponseEntity<List<User>> getListByCity(@RequestParam String city) {
	        List<User> user = userService.getListByCity(city);
	        return ResponseEntity.ok(user);
	    }

	    @GetMapping("/{username}")
	    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
	        User user = userService.getUserByUserName(username);
	        return ResponseEntity.ok(user);
	    }

}
