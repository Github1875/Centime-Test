package com.centime.service2.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class Service2Controller {

	private static Logger logger = Logger.getLogger(Service2Controller.class);
	
	@GetMapping("/message")
	public ResponseEntity<String> getMessage() {
		logger.info("Received API call - getMessage");
		String response = "Hello";
		
		ResponseEntity<String> entity = new ResponseEntity<String>(response, HttpStatus.OK);
		return entity;
	}
}
