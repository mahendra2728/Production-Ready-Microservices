package com.pm.users.service;

import java.util.List;

import com.pm.rentapp.commons.model.UserCreationResponse;
import com.pm.rentapp.commons.model.UserRequestModel;

public interface UserService {

	UserCreationResponse save(UserRequestModel userRequest);

	List<UserCreationResponse> findAll();
}
