package com.centime.service1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.centime.service1.entity.Legend;
@Service
public interface LegendService {

	public void save(List<Legend> details) ;
	public List<Legend> fetchAllLegends();
	public Legend findLegend(int id) ;
}
