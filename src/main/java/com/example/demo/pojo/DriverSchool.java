package com.example.demo.pojo;

import java.io.Serializable;

public class DriverSchool  implements Serializable {

	private Integer did;
	
	private String dname;
	
	private String address;

	private String phone;
	
//	private int cityAreaId;
	private CityArea cityArea;


	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CityArea getCityArea() {
		return cityArea;
	}

	public void setCityArea(CityArea cityArea) {
		this.cityArea = cityArea;
	}
	
	
	
	
}
