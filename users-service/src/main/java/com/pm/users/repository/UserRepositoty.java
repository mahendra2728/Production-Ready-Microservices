package com.pm.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.rentapp.commons.model.User;

public interface UserRepositoty extends JpaRepository<User, Integer> {

}


