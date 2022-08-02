package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.TouristNotFoundException;
import com.nt.model.Tourist;
import com.nt.repo.ITouristRepo;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {
		int idVal = repo.save(tourist).getTid();
		return "Tourist is registered having the id value :: "+idVal;
	}
	
	@Override
	public List<Tourist> fetchAllTorists() {
		List<Tourist> list = repo.findAll();
		list.sort((t1, t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}
	
	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		return repo.findById(tid)
				.orElseThrow(()->new TouristNotFoundException(tid+" tourist not found."));
	}
	
	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> opt = repo.findById(tourist.getTid());
		if(opt.isPresent()) {
			repo.save(tourist);
			return tourist.getTid()+" tourist is updated.";
		}else {
			throw new TouristNotFoundException(tourist.getTid()+" tourist not found.");
		}
	}

	@Override
	public String deleteTorist(Integer tid) throws TouristNotFoundException{
		Optional<Tourist> opt = repo.findById(tid);
		if(opt.isPresent()) {
			Tourist tourist = opt.get();
			repo.delete(tourist);
			return tid+" tourist deleted.";
		}else {
			throw new TouristNotFoundException(tid + " tourist not found.");
		}
	}
	
	@Override
	public String updateTouristBudgetById(Integer tid, Float hikePercentage) throws TouristNotFoundException {
		Optional<Tourist> opt = repo.findById(tid);
		if(opt.isPresent()) {
			Tourist tourist = opt.get();
			tourist.setPrice(tourist.getPrice() + (tourist.getPrice() * hikePercentage/100));
			repo.save(tourist);
			return tid+" tourist budget is updated.";
		}else {
			throw new TouristNotFoundException(tid + " tourist not found.");
		}
	}
}
