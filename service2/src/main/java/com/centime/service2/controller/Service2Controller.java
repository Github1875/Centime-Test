package com.centime.service2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class Service2Controller {

	@GetMapping("/message")
	public ResponseEntity<String> getMessage() {
		System.out.println("working");
		String response = "Hello";
		
		ResponseEntity<String> entity = new ResponseEntity<String>(response, HttpStatus.OK);
		return entity;
	}
}
