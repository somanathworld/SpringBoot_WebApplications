package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{

	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public Employee fetchEmployeeByEno(int eno) throws EmployeeNotFoundException {
		Optional<Employee> opt = repo.findById(eno);
		if(opt.isPresent()){
			return opt.get();
		}else {
			throw new EmployeeNotFoundException("Problem in getting employee record.");
		}
	}
	
}
