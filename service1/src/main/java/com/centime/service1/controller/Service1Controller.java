package com.centime.service1.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.centime.service1.bean.Details;
import com.centime.service1.bean.Response;
import com.centime.service1.entity.Legend;
import com.centime.service1.service.LegendHelper;
import com.centime.service1.service.LegendService;

@RestController
@RequestMapping("/services")
public class Service1Controller {

	private static Logger logger = Logger.getLogger(Service1Controller.class);
	 
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LegendService legendService;
	
	@Autowired
	private LegendHelper helper;
	
	@GetMapping("/status")
	public String getServiceStatus() {
		
		logger.info("Received API call - check Service Status");
		return "Up";
	}
	
	@PostMapping("/concate")
	public ResponseEntity<String> concateResponses(@Valid @RequestBody Details requestBody) {
	
		logger.info("Received API call - concateResponses");
		String response1 = restTemplate.getForObject("http://message-service/services/message", String.class);
		String response2 = restTemplate.postForObject("http://concate-service/services/concate", requestBody, String.class);
		return new ResponseEntity<String>(response1+response2, HttpStatus.OK);
	}
	
	@GetMapping("/legends/{id}")
	public Legend getLegendDetails(@PathVariable("id") int id) {
		
		logger.info("Received API call - getDetails by id "+id);
		return legendService.findLegend(id);
	}
	
	@GetMapping("/legends/details")
	public Collection<Response> getAllLegends() {
		
		logger.info("Received API call - fetch all Legend details");
		List<Legend> elements = legendService.fetchAllLegends();
		return helper.buildNestedJson(elements);
	}
	
	@PostMapping("/legends")
	public void saveDetails(@RequestBody List<Legend> request) {
		logger.info("Received API call - save legegnd details");
		legendService.save(request);
	}
}
