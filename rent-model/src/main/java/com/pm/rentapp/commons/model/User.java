package com.pm.rentapp.commons.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private String userId;
	private String name;
	private String username;
	private String password;
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Role.class)
	@JoinTable(name ="users_roles",joinColumns= @JoinColumn(name = "id"), inverseJoinColumns= @JoinColumn(name = "role_id"))
	List<Role> roles;
	
}
