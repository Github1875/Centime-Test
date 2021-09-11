package com.centime.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centime.bean.Details;
import com.centime.service.Service2Client;
import com.centime.service.Service3Client;

@RestController
@RequestMapping("/service1")
public class Service1Controller {

	@Autowired
	private Service2Client client2;
	
	@Autowired
	private Service3Client client3;
	
	@GetMapping("/status")
	public String getServiceStatus() {
		
		return "Up";
	}
	
	@PostMapping("/concate")
	public ResponseEntity<String> concateResponses(@Valid @RequestBody Details requestBody) {
	
		ResponseEntity<String> response = client2.getMessage();
		String response1 = response.getBody();
		String response2 = client3.concateDataElements(requestBody);		
		return new ResponseEntity<String>(response1+response2, HttpStatus.OK);
	}
}
