package com.nt.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nt.repository.IHumanActivitiesRepo;

@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService{

	@Autowired
	private IHumanActivitiesRepo repo;
	
	@Autowired
	private Environment env;
	
	@Override
	public Set<String> getAllCountries() {
		Locale locales[] = Locale.getAvailableLocales();
		Set<String> countriesSet = new TreeSet<>();
		for(Locale l : locales) {
			countriesSet.add(l.getDisplayCountry());
		}
		return countriesSet;
	}
	
	@Override
	public Set<String> getAllLanguages() {
		Locale locales[] = Locale.getAvailableLocales();
		Set<String> languagesSet = new TreeSet<>();
		for(Locale l : locales) {
			languagesSet.add(l.getDisplayLanguage());
		}			
		return languagesSet;
	}
	
	@Override
	public Set<String> getAllHobbies() {
		return repo.getAllHobbies();
	}
	
	@Override
	public List<String> getStatesByCountry(String country) {
		String statesInfo = env.getRequiredProperty(country);
		System.out.println(statesInfo);
		List<String> statesList = Arrays.asList(statesInfo.split(","));
		System.out.println(statesList);
		Collections.sort(statesList);
		return statesList;
	}
}
