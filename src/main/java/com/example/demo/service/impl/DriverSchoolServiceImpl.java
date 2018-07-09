package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.dao.DriverSchoolDao;
import com.example.demo.pojo.DriverSchool;
import com.example.demo.pojo.Pager;
import com.example.demo.service.DriverSchoolService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ��У��ҵ��ӿ�ʵ����
 * @author ASUS
 *
 */
@Service("driverSchoolService")
public class DriverSchoolServiceImpl implements DriverSchoolService{
	@Autowired
	private DriverSchoolDao driverSchoolDao;
	public void setDriverSchoolDao(DriverSchoolDao driverSchoolDao) {
		this.driverSchoolDao = driverSchoolDao;
	}

	public List<DriverSchool> getAllByPager(Pager pager, DriverSchool school) {
		int n=this.driverSchoolDao.getCounts(school);
		System.out.println(n);
		pager.setTotalCounts(n);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("school", school);
		map.put("pageIndex", (pager.getCurrPage()-1)*pager.getPageSize());
		map.put("pageSize", pager.getPageSize());
		return this.driverSchoolDao.getAllByPager(map);
	}


	public int insert(DriverSchool school) {
		return this.driverSchoolDao.insert(school);
	}

	public int del(int did) {
		return this.driverSchoolDao.del(did);
	}

	public DriverSchool getDetail(int did) {
		return this.driverSchoolDao.getDetail(did);
	}

	public int update(DriverSchool school) {
		return this.driverSchoolDao.update(school);
	}




	

	
	
	
}
