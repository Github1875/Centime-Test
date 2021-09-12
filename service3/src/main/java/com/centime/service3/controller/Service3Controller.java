package com.centime.service3.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centime.service3.bean.Details;

@RestController
@RequestMapping("/services")
public class Service3Controller {

	@PostMapping("/concate")
	public String concateDataElements(@Valid @RequestBody Details request) {
	
		return request.getName()+" "+request.getSurName();
	}
}
