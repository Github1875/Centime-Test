package com.centime.service1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.centime.service1.bean.Details;

@FeignClient(name="/service3")
public interface Service3Client {

	@PostMapping("/concate")
	public String concateDataElements(@RequestBody Details request);
}
