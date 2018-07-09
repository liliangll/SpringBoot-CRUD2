package com.example.demo.dao;

import com.example.demo.pojo.DriverSchool;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DriverSchoolDao {

	public int getCounts(DriverSchool school);

	public List<DriverSchool> getAllByPager(Map map);

	public int insert(DriverSchool school);

	public int del(int did);

	public DriverSchool getDetail(int did);

	public int update(DriverSchool school);
}
