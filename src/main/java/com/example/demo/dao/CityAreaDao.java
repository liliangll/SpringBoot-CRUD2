package com.example.demo.dao;

import com.example.demo.pojo.CityArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface CityAreaDao {

	//public List<CityArea> getAllCityAreas();
	List<Map<String,Object>> getAllCityAreas();
}
