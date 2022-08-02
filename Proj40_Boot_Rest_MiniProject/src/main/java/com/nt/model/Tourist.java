package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "REST_TOURIST")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tourist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer tid;
	
	@NonNull
	@Column(length = 20)
	public String name;
	
	@NonNull
	@Column(length = 20)
	public String city;
	
	@NonNull
	@Column(length = 20)
	public String packageType;
	
	@NonNull
	public Double price;

}
