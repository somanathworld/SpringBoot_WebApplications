package com.nt.service;

import java.util.List;

import com.nt.exception.TouristNotFoundException;
import com.nt.model.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);

	public List<Tourist> fetchAllTorists();

	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException;

	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;

	public String deleteTorist(Integer tid) throws TouristNotFoundException;

	public String updateTouristBudgetById(Integer tid, Float hikePercentage) throws TouristNotFoundException;
}
