package cn.tedu.ems.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.dao.UserDAO;

@Controller
public class CallProcedure {
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@RequestMapping("/callpro")
	public String callmybatispro() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("username", "mary");
		map.put("pwd", "000000");
		map.put("count",null);
		userDAO.killByProcedure(map);
		System.out.println((Integer)map.get("count"));
		return "index";
	}
}
