package com.example.demo.service;


import com.example.demo.pojo.DriverSchool;
import com.example.demo.pojo.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface DriverSchoolService {

		public List<DriverSchool> getAllByPager(Pager pager, DriverSchool school);

		public int insert(DriverSchool school);

		public int del(int did);

		public DriverSchool getDetail(int did);

		public int update(DriverSchool school);
}
