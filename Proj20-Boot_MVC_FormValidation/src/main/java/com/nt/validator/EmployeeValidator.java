package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("EmployeeValidator.supports()");  //check whether handler method is passing
		return clazz.isAssignableFrom(Employee.class);       //correct command class obj or not
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		//type casting
		Employee emp = (Employee)target;
		
		if(emp.getEname() == null || emp.getEname().isBlank()) 
			errors.rejectValue("ename", "emp.ename.required");
		else if(emp.getEname().length()<5)
			errors.rejectValue("ename", "emp.ename.minlength");

		if(emp.getJob() == null || emp.getJob().isBlank()) 
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<5)
			errors.rejectValue("job", "emp.job.minlength");

		if(emp.getSal() == null) 
			errors.rejectValue("sal", "emp.sal.required");
		else if(emp.getSal().isNaN())
			errors.rejectValue("sal", "emp.sal.numeric");
		else if(emp.getSal()<20000 || emp.getSal()>100000)
			errors.rejectValue("sal", "emp.sal.range");

		if(emp.getDeptno() == null) 
			errors.rejectValue("deptno", "emp.deptno.required");
		else if(((Float)emp.getDeptno().floatValue()).isNaN())
			errors.rejectValue("deptno", "emp.deptno.numeric");
		else if(emp.getDeptno()<10 || emp.getDeptno()>90)
			errors.rejectValue("deptno", "emp.deptno.range");
	
		
		//application b.logic error
		if(emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN")) {
			errors.rejectValue("job", "e.job.restriction");
		}

	}

}
