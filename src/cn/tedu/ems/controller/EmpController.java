package cn.tedu.ems.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.dao.EmployeeDAO;
import cn.tedu.ems.entity.Employee;
import cn.tedu.ems.service.ApplicationException;
import cn.tedu.ems.util.PageArgs;

@Controller
public class EmpController {

	@Resource(name = "employeeDAO")
	private EmployeeDAO employeeDAO;

	@RequestMapping("/list.do")
	public String listAllEmployees(HttpServletRequest request,HttpSession session) {
		Integer count=employeeDAO.findAllNum();
		String pageNum = request.getParameter("pageNum");
		PageArgs pager =new PageArgs();
		pager.setCount(count);
		if(pageNum!=null) {
			pager.setPageNum(Integer.parseInt(pageNum));
		}else {
			pager.setPageNum(1);
		}
		int start = (pager.getPageNum()-1)*pager.getPageSize()+1;
		int end =pager.getPageNum()*pager.getPageSize();
		List<Employee> employees = employeeDAO.findAll(start,end);
		session.setAttribute("pager", pager);
		session.setAttribute("employees", employees);
		return "listEmp";

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
		System.out.println(e.getMessage());
		return "error";
	}

	@RequestMapping("/del.do")
	public String deleteById(HttpServletRequest request) {
		String id = request.getParameter("id");
		employeeDAO.delete(Integer.parseInt(id));
		return "redirect:list.do";

	}

	@RequestMapping("/add.do")
	public String addEmployee(HttpServletRequest request) {
		// 调用request对象提供的方法来读取请求参数值
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");

		// 一般来说，服务器端应该对请求参数值做一些
		// 合法性检查，比如检查姓名是否为空，这儿
		// 暂时不做。

		// 将员工信息插入到数据库
		Employee e = new Employee();
		e.setName(name);
		e.setSalary(Double.parseDouble(salary));
		e.setAge(Integer.parseInt(age));
		employeeDAO.save(e);
		return "redirect:list.do";

	}

	@RequestMapping("/load.do")
	public String findById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Employee e = employeeDAO.findById(Integer.parseInt(id));
		request.setAttribute("e", e);
		return "updateEmp";

	}

	@RequestMapping("/modify.do")
	public String modifyEmployee(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");

		Employee e = new Employee();
		e.setId(Integer.parseInt(id));
		e.setName(name);
		e.setSalary(Double.parseDouble(salary));
		e.setAge(Integer.parseInt(age));
		employeeDAO.modify(e);
		// 重定向到员工列表
		return "redirect:list.do";

	}

}
