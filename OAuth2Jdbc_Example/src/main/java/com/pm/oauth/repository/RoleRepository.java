package com.pm.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.rentapp.commons.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{

}
