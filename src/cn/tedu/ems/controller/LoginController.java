package cn.tedu.ems.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.ApplicationException;
import cn.tedu.ems.service.LoginService;

@Controller
public class LoginController {
	
	Logger logger = LogManager.getLogger(LoginController.class);
	
	@Resource(name = "loginService")
	private LoginService loginService;
	
	@RequestMapping("/download.do")
	public void download(HttpServletResponse response) throws Exception {
		
		String templatePath = "D:\\template2.doc";  
	      InputStream is = new FileInputStream(templatePath);  
	      HWPFDocument doc = new HWPFDocument(is);  
	      Range range = doc.getRange();  
	      //把range范围内的${reportDate}替换为当前的日期  
	      range.replaceText("${reportDate}", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));  
	      range.replaceText("${appleAmt}", "100.00");  
	      range.replaceText("${bananaAmt}", "200.00");  
	      range.replaceText("${totalAmt}", "300.00"); 
	      range.replaceText("${price}", "10.00");
	      OutputStream os=response.getOutputStream();
	      //OutputStream os = new FileOutputStream("D:\\write2.doc");  
	      //把doc输出到输出流中  
	      doc.write(os);
	}
	
	@RequestMapping("/toDownload.do")
	public String toDownload() {
		System.out.println("download");
		
		return "download";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		
		logger.debug("登陆");
		logger.info("登陆");
		logger.error("登陆");
		System.out.println("toLogin()");
		return "login";
	}

	@ExceptionHandler
	public String handleException(Exception e, HttpServletRequest request) {
		System.out.println("handleException()");
		if (e instanceof ApplicationException) {
			// 应用异常，明确提示用户
			request.setAttribute("login_failed", e.getMessage());
			return "login";
		}
		// 系统异常，提示用户稍后重试
		return "error";
	}

	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpSession session) {

		System.out.println("login()");
		// 读取用户名和密码
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println(username + " " + pwd);
		/*
		 * 调用业务层的服务 注：需要处理业务层所抛出的异常，将异常转换成 用户能理解的信息。 系统异常：可以提示用户稍后重试。
		 * 应用异常：明确提示用户采取正确的操作。
		 */
		User user = loginService.checkLogin(username, pwd);

		// 登录成功，将user绑订到session对象上。
		// 用于session验证
		session.setAttribute("user", user);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("name", "john");
		data.put("value", 123);
		request.setAttribute("data", data);

		// 登录成功
		return "index";
	}

}
