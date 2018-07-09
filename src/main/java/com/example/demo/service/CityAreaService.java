package com.example.demo.service;

import com.example.demo.pojo.CityArea;
import com.example.demo.util.ResultObjStr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CityAreaService {

//	public List<CityArea> getAllCityAreas();
	List<Map<String,Object>> getAllCityAreas();
	ResultObjStr exportExcel(Integer myId, String fileName, String excelFormat, OutputStream fileOut);

}
