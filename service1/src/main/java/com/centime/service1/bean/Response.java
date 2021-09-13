package com.centime.service1.bean;

import java.util.ArrayList;
import java.util.List;

public class Response {

	private String name;
	
	private List<Response> subClasses;

	public Response() {
		super();
	}

	public Response(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Response> getSubClasses() {
		if(null == this.subClasses) {
			this.subClasses = new ArrayList<Response>();
		}
		return subClasses;
	}

	public void setSubClasses(List<Response> subClasses) {
		this.subClasses = subClasses;
	}
	
}
