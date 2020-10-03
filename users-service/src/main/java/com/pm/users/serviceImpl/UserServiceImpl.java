package com.pm.users.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pm.rentapp.commons.model.User;
import com.pm.rentapp.commons.model.UserCreationResponse;
import com.pm.rentapp.commons.model.UserRequestModel;
import com.pm.users.repository.UserRepositoty;
import com.pm.users.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositoty userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserCreationResponse save(UserRequestModel userRequest) {
				
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user=mapper.map(userRequest, User.class);
		
		//Password Encryption & creating random userId
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setUserId(UUID.randomUUID().toString());
		
		User createdUser=userRepository.save(user);
		
		UserCreationResponse response=mapper.map(createdUser, UserCreationResponse.class);
		return response;
	}

	@Override
	public List<UserCreationResponse> findAll() {
		
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<User> usersList=userRepository.findAll();
		
		List<UserCreationResponse> response=mapper.map(usersList,new TypeToken<List<UserCreationResponse>>(){}.getType());
		return response;
	}
	

}
