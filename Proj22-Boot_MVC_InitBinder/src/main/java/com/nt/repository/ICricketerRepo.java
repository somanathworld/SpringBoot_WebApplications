package com.nt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.model.Cricketer;

public interface ICricketerRepo extends PagingAndSortingRepository<Cricketer, Integer>{

}
