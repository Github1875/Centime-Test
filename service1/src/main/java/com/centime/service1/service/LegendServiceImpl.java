package com.centime.service1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centime.service1.entity.Legend;
import com.centime.service1.repository.LegendJPARepository;

@Service
public class LegendServiceImpl implements LegendService {

	@Autowired
	LegendJPARepository repository;
	
	@Override
	public List<Legend> fetchAllLegends() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Legend findLegend(int id) {
		// TODO Auto-generated method stub
		Optional<Legend> legend = repository.findById(id);
		if(legend.isPresent()) {
			return legend.get();
		}
		return null;
	}

	@Override
	public void save(List<Legend> details) {
		// TODO Auto-generated method stub
		repository.saveAll(details);
	}

}
