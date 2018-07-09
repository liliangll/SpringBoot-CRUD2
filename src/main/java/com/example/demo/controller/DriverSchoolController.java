package com.example.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojo.CityArea;
import com.example.demo.pojo.DriverSchool;
import com.example.demo.pojo.Pager;
import com.example.demo.service.CityAreaService;
import com.example.demo.service.DriverSchoolService;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class DriverSchoolController {
	private static Logger logger = LoggerFactory.getLogger(DriverSchoolController.class);

	@Autowired
	private DriverSchoolService driverSchoolService;
	public void setDriverSchoolService(DriverSchoolService driverSchoolService) {
		this.driverSchoolService = driverSchoolService;
	}
	/*@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}*/
	@Autowired
	private CityAreaService cityAreaService;
	public void setCityAreaService(CityAreaService cityAreaService) {
		this.cityAreaService = cityAreaService;
	}
	
	//进入修改
	@RequestMapping(value="/toUpdate.do/{did}",method = {RequestMethod.GET,RequestMethod.POST})
	public String toUpdate(@PathVariable Integer did,Model model){
		DriverSchool school=this.driverSchoolService.getDetail(did);
		model.addAttribute("school", school);//把原来的值存到请求中

//		List<CityArea> clist=this.cityAreaService.getAllCityAreas();//得到所有城区

		List<Map<String, Object>> clist=this.cityAreaService.getAllCityAreas();
		/*if (clist.size()>0)
		{
			Map<String, Object> xx=clist.get(0);
			System.out.println(xx);
		}*/
		//		clist.add(0, new CityArea(-1,"请选择"));
		model.addAttribute("clist", clist);//将下拉框数据传给页面
		return "update";//去往修改页面
	}
	
	//提交修改
	@PostMapping(value="/doUpdate.do")
	public String doUpdate(DriverSchool school,Model model){
		int n= driverSchoolService.update(school);
		if(n>0){
			return "redirect:/toPager.do?flag=yes";//转发到分页控制器
		}else{
			return "redirect:/toPager.do?flag=no";
		}
	}


	//进入新增
	@GetMapping(value="/toInsert.do")
	public String toInsert(Model model){
//		List<CityArea> clist=this.cityAreaService.getAllCityAreas();//得到所有城区
		List<Map<String, Object>> clist=this.cityAreaService.getAllCityAreas();//得到所有城区
		model.addAttribute("clist", clist);//将下拉框数据传给页面
		return "insert";//去往新增页面
	}
	
	//提交新增
	@PutMapping(value="/doInsert.do")
	public String doInsert(DriverSchool school,Model model){
		int n= driverSchoolService.insert(school);
		if(n>0){
			return "redirect:/toPager.do?flag=yes";//转发到分页控制器
		}else{
			return "redirect:/toPager.do?flag=no";
		}
	}


	@RequestMapping(value="/toPager.do",method={RequestMethod.GET,RequestMethod.POST})
	public String toPager(Pager pager,DriverSchool school,Model model){
		if(pager==null){
			pager=new Pager();//判断分页对象是否为空，为空就默认为第一页
		}
		List<DriverSchool> list=this.driverSchoolService.getAllByPager(pager, school);
		model.addAttribute("list", list);//把数据传给页面
		model.addAttribute("pager", pager);//把分页对象传给页面
		model.addAttribute("school", school);//把查询条件传给页面

//		List<CityArea> clist=this.cityAreaService.getAllCityAreas();//得到所有城区
		List<Map<String, Object>> clist=this.cityAreaService.getAllCityAreas();//得到所有城区
		model.addAttribute("clist", clist);//将下拉框数据传给页面

		return "select";
	}

	@RequestMapping(value="/doDel.do",method = {RequestMethod.GET,RequestMethod.POST})
	public String toPager(@RequestParam int did){
		int n= driverSchoolService.del(did);
		if(n>0){
			return "redirect:/toPager.do?flag=yes";
		}else{
			return "redirect:/toPager.do?flag=no";
		}
	
	}

	@GetMapping(value = "/exportExcel")
	public String exportExcel (Integer myid, String fileName, String excelFormat, HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("application/force-download");// 设置下载框
		response.addHeader("Content-Disposition","attachment;filename="+fileName+"." + excelFormat);// 设置下载文件名（*+fileName这个值可以定死，下载时会引用这个名字如：”aa.xml“）
		try {
			OutputStream out = response.getOutputStream();//拿到用户选择的路径
			this.cityAreaService.exportExcel(myid, fileName, excelFormat, out);
		} catch (IOException e) {
			logger.error("下载excel后台错误 : " + e.getMessage());
		}
		return null;
	}
}
