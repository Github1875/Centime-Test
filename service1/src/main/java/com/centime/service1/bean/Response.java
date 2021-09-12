package com.centime.service1.bean;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class Response {

	@NotBlank
	private String name;
	
	@NotBlank
	private List<Response> subClasses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Response> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(List<Response> subClasses) {
		this.subClasses = subClasses;
	}
	
}
