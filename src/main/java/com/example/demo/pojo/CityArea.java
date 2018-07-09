package com.example.demo.pojo;

import java.io.Serializable;

public class CityArea implements Serializable {
	private Integer cid;
	private String name;
	public CityArea(){}
	public CityArea(int cid, String name) {
		this.cid = cid;
		this.name = name;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
