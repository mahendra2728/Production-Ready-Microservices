package com.pm.rentapp.commons.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreationResponse {

	private String userId;
	private String name;
	private String username;
	private String email;
	
	private List<Role> roles;
}
