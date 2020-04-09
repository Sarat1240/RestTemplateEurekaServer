package com.example.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeptApplication.class, args);
	}

}
