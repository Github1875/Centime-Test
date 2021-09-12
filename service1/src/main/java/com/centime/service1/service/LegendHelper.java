package com.centime.service1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.centime.service1.bean.Response;
import com.centime.service1.entity.Legend;

@Component
public class LegendHelper {

	public List<Response> buildNestedJson(List<Legend> elements) {
		
		List<Response> result = new ArrayList<>();
		for(int i=0;i<elements.size();i++) {
			if(elements.get(i).getParentId() == 0) {
				Response resp = new Response();
				resp.setName(elements.get(i).getName());
				result.add(resp);
			}
		}
		return result;
	}
}
