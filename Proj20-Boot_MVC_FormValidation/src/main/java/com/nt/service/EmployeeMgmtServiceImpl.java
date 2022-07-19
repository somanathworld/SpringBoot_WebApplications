package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	
	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public Iterable<Employee> getAllEmployees() {
		return repo.findAll();
	}
	
	@Override
	public String insertEmployee(Employee emp) {
		return "Employee inserted with id value : "+repo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeByEno(int eno) {
		return repo.findById(eno).get();
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		return repo.save(emp).getEmpno()+" employee updated.";
	}
	
	@Override
	public String deleteEmployeeByEno(int eno) {
		repo.deleteById(eno);
		return eno+" employee number Employee deleted.";
	}
	
	@Override
	public Page<Employee> getEmployeePageData(Pageable page) {
		return repo.findAll(page);
	}
}
