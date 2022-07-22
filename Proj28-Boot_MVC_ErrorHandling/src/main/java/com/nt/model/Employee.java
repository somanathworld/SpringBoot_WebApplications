package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "EMP")
public class Employee {

	@Id
	@GeneratedValue
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptno;
	
}
