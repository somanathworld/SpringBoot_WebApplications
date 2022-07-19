package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Cricketer;
import com.nt.repository.ICricketerRepo;

@Service
public class CricketMgmtServiceImpl implements ICricketerMgmtService {

	@Autowired
	private ICricketerRepo repo;
	
	@Override
	public String registerCricketer(Cricketer crck) {
		return "Cricketer is saved with cid : "+repo.save(crck).getCid();
	}

}
