package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Faculty;
import com.nt.repository.IFacultyRepo;

@Service
public class FacultyMgmtServiceImpl implements IFacultyMgmtService{

	@Autowired
	private IFacultyRepo repo;
	
	@Override
	public Iterable<Faculty> getAllFaculty() {
		return repo.findAll();
	}
}
