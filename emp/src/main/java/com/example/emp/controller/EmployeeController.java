package com.example.emp.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping
	public String getEmpForDepts()
	{
		final String uri = "http://dept-service/depts";

		String result = restTemplate.getForObject(uri, String.class);

		return result;
	}
	
	@GetMapping("/{empId}")
	public String getEmpForDepts(@PathVariable String empId)
	{
		final String uri = "http://dept-service/depts/"+empId;

		String result = restTemplate.getForObject(uri, String.class);

		return result;
	}
	
	@GetMapping("/byparam")
	public String getEmpDeptsByReqParam(@RequestParam String empId) {

		 String uri = "http://dept-service/depts/byparam";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		Map<String, String> params = new HashMap<String, String>();
		params.put("empId", empId);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		for (Map.Entry<String, String> entry : params.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}

		String result = restTemplate.getForObject(builder.toUriString(), String.class);

		return result;

	}

	@GetMapping("/postparam")
	public ResponseEntity<String> testPostWithParam(@RequestParam String userId) {

	//	String uri = "http://localhost:8080/depts/byparam";
		String uri = "http://dept-service/depts/byparam";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	    map.add("userId", userId);

		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(map,
				headers);

		ResponseEntity<String> response = restTemplate.postForEntity(uri, httpEntity, String.class);

		System.out.println(response);
		return response;
	}

	
	@GetMapping("/bybody")
	public ResponseEntity<String> testReqBody() throws JSONException {

		//String uri = "http://localhost:8080/depts/bybody";
		String uri = "http://dept-service/depts/bybody";
		

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject request = new JSONObject();
		request.put("id", 110);
		request.put("depName", "test10");

		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

		System.out.println(response);
		return response;

	}

	@GetMapping("/bybody2")
	public ResponseEntity<String> testReqBody2() throws JSONException {

		//String uri = "http://localhost:8080/depts/bybody";
		String uri = "http://dept-service/depts/bybody";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject request = new JSONObject();
		request.put("id", 1122);
		request.put("depName", "usk1");

		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		return response;

	}
	
	@GetMapping("/bybody3")
	public ResponseEntity<String> testReqBody3() throws JSONException {

		//String uri = "http://localhost:8080/depts/bybody";
		String uri = "http://dept-service/depts/bybody";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject request = new JSONObject();
		request.put("id", 1122);
		request.put("depName", "usk1");

		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		return response;

	}




}
