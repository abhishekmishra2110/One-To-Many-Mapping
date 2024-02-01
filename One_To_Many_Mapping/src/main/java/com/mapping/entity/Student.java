package com.mapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="jpa_student")
public class Student {
	@Id
	private int studentId;
	private String sudentName;
	private String about;
	
	
	
	@OneToMany(mappedBy ="student",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Address> addressList=new ArrayList<>();



	public Student(int studentId, String sudentName, String about, List<Address> addressList) {
		super();
		this.studentId = studentId;
		this.sudentName = sudentName;
		this.about = about;
		this.addressList = addressList;
	}
	
	
	public Student() {
		super();
	}
	
	


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	
	public String getSudentName() {
		return sudentName;
	}


	public void setSudentName(String sudentName) {
		this.sudentName = sudentName;
	}


	
	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}

	

	public List<Address> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	
	
	
	
	
	
	
	

}
