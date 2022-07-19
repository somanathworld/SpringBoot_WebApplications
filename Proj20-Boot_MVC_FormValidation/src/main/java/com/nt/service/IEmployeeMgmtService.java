package com.nt.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	public Iterable<Employee> getAllEmployees();
	public String insertEmployee(Employee emp);
	public Employee getEmployeeByEno(int eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeByEno(int eno);
	public Page<Employee> getEmployeePageData(Pageable page);
}
