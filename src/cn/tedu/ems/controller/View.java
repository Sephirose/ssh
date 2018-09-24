package cn.tedu.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View {

	@RequestMapping("/test.do")
	public String login() {
		System.out.println("test");
		return "WEB-INF/login";
	}
	
}
