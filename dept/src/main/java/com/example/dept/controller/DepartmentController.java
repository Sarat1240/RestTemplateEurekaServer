package com.example.dept.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dept.pojo.Department;


@RestController
@RequestMapping(value = "/depts")
public class DepartmentController {
	
	@GetMapping
	public List<Department> getAll()
	{
		System.out.println("in getAll()");
		List<Department> depList = new ArrayList<Department>();
		
		depList.add(new Department(1, "dept1"));
		depList.add(new Department(2, "dept2"));
	
		return depList;
	}
	
	@GetMapping("/{deptId}")
	public List<Department> getAllById(@PathVariable String deptId) {

		System.out.println("from Department controller ===============>>" + deptId);

		List<Department> depList = new ArrayList<Department>();
		
		depList.add(new Department(3, "dept3"));
		depList.add(new Department(4, "dept4"));
	
		return depList;
	}

	@GetMapping("/byparam")
	public List<Department> getAllByReqParam(@RequestParam String empId) {

		System.out.println("from Department controller ===============>>" + empId);
		List<Department> depList = new ArrayList<Department>();
		
		depList.add(new Department(5, "dept5"));
		depList.add(new Department(6, "dept6"));
	
		return depList;
		
	}

	@PostMapping("/byparam")
	public List<Department> getAllByPostReqParam() {

		System.out.println("from Department controller ===============>>");

		List<Department> depList = new ArrayList<Department>();
		
		depList.add(new Department(7, "dept7"));
		depList.add(new Department(8, "dept8"));
	
		return depList;
	}

	@PostMapping("/bybody")
	public Department getAllByPostReqBody(@RequestBody Department department) {

		System.out.println("from Department controller ===============>>");

		department.setdepName(department.getdepName() + "updated");
		System.out.println(department.getdepName());

		return department;
	}
}

