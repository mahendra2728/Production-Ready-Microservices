package com.pm.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.rentapp.commons.model.UserCreationResponse;
import com.pm.rentapp.commons.model.UserRequestModel;
import com.pm.users.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/users")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> save(@RequestBody UserRequestModel userRequest){
		
		UserCreationResponse respose=userService.save(userRequest);
		if(respose==null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<UserCreationResponse>(respose, HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<?> getAllUsers(){
		List<UserCreationResponse> respose=userService.findAll();
		if(respose==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(respose, HttpStatus.OK);
		
	}
}
