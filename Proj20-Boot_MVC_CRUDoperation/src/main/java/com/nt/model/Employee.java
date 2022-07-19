package com.nt.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Table(name = "BOOT_EMP")
@Entity
@SQLDelete(sql = "UPDATE BOOT_EMP SET STATUS='DELETE' WHERE EMPNO=?")
@Where(clause = "STATUS <> 'DELETE'")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "emp_no_seq1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
	private Integer deptno;
}
