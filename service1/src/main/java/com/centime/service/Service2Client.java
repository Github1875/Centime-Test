package com.centime.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="/service2")
public interface Service2Client {

	@GetMapping("/message")
	public ResponseEntity<String> getMessage();
}
