package com.centime.service1.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Details {

	@Valid
	@NotNull
	private String name;
	
	@Valid
	@NotNull
	private String surName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
}
