package com.nt.service;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	public Employee fetchEmployeeByEno(int eno)throws EmployeeNotFoundException;
}
