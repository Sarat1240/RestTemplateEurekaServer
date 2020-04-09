package com.example.dept.pojo;

import java.io.Serializable;

import lombok.Data;


public class Department implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String depName;
	
	
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Department(int id, String depName) {
		super();
		this.id = id;
		this.depName = depName;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the depName
	 */
	public String getdepName() {
		return depName;
	}
	/**
	 * @param depName the depName to set
	 */
	public void setdepName(String depName) {
		this.depName = depName;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + "]";
	}
	
	

}
