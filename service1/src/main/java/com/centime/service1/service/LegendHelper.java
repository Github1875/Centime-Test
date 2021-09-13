package com.centime.service1.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.centime.service1.bean.Response;
import com.centime.service1.entity.Legend;

@Component
public class LegendHelper {

	public Collection<Response> buildNestedJson(List<Legend> elements) {

		Map<Integer, Response> entity = new HashMap<Integer, Response>();

		for (int i = 0; i < elements.size(); i++) {

			System.out.println("element " + elements.get(i).getId());
			if (elements.get(i).getParentId() == 0) {

				System.out.println("element " + elements.get(i).getParentId());
				Response resp = new Response(elements.get(i).getName());
				entity.put(elements.get(i).getId(), resp);

			} else {

				if (entity.containsKey(elements.get(i).getParentId())) {

					System.out.println("adding childs");
					Response value = entity.get(elements.get(i).getParentId());
					value.getSubClasses().add(new Response(elements.get(i).getName()));
					
			
				} else if (entity.containsKey(elements.get(elements.get(i).getParentId()).getParentId())) {
						System.out.println("adding sub childs");
						
					}
			}
		}

		return entity.values();
	}
}
