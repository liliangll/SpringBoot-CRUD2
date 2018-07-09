package com.example.demo.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.demo.dao.CityAreaDao;
import com.example.demo.poi.excel.ExcelUtil;
import com.example.demo.service.CityAreaService;
import com.example.demo.util.ResultObjStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author ASUS
 *
 */
@Service("cityAreaService")
public class CityAreaServiceImpl implements CityAreaService{
	@Autowired
	private CityAreaDao cityAreaDao;
	public void setCityAreaDao(CityAreaDao cityAreaDao) {
		this.cityAreaDao = cityAreaDao;
	}
//	public List<CityArea> getAllCityAreas() {
//		return this.cityAreaDao.getAllCityAreas();
//	}


	@Override
	public List<Map<String, Object>> getAllCityAreas() {
		return cityAreaDao.getAllCityAreas();
	}

	@Override
	public ResultObjStr exportExcel(Integer myId, String fileName, String excelFormat, OutputStream fileOut) {
		List<Map<String, Object>> allSiteInfos = this.cityAreaDao.getAllCityAreas();
		List<List<Object>> excels = new ArrayList<>();
		for (Map<String, Object> map : allSiteInfos) {
			List<Object> row = new ArrayList<>();
			String cid = map.get("cid").toString();
			String name = map.get("name").toString();
//			String createTime = map.get("create_time").toString();
//			String url = map.get("url").toString();
			if (cid.length() > 3200) {
				cid = cid.substring(0,3200);
			}
			row.add(cid);
			row.add(name);
//			row.add(createTime);
//			row.add(url);
			excels.add(row);
		}
		ExcelUtil.exportExcel(excels, fileName, excelFormat, fileOut);
		return new ResultObjStr(ResultObjStr.SUCCESS, "下载成功", null);
	}


}
