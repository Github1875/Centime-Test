package com.centime.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaServer
@SpringBootApplication
@EnableSwagger2
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate getInstance() {
		return new RestTemplate();
	}
	
	@Bean
	public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	    	         .apis(RequestHandlerSelectors.basePackage("com.centime.service1")).build();
		
	}
}
