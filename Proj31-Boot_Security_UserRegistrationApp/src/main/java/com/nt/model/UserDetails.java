package com.nt.model;

import java.util.Set;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;

@Table(name="SECURITY_USERS")
@Entity
@Data
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer unid;
	
	@Column(length = 20, unique = true, nullable = false)
	private String uname;
	
	@Column(length = 150, nullable = false)
	private String pwd;
	
	@Column(length = 40, unique = true, nullable = false)
	private String email;
	
	private Boolean status = true;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "SECURITY_ROLES", 
						joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "unid"))
	@Column(name="role")
//	@OrderColumn(name="ROLES_INDEX")
//	@ListIndexBase(value = 1)
	private Set<String> roles;
	
}
