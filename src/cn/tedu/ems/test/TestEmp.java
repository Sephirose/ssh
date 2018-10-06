package cn.tedu.ems.test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ems.dao.EmployeeDAO;
import cn.tedu.ems.entity.Employee;

public class TestEmp {
	
	@Test
	public void testEmployee() throws SQLException {
		String config = "applicationContext.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		EmployeeDAO dao =(EmployeeDAO)ac.getBean("employeeDAO",EmployeeDAO.class);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("age", "34");
		List<Employee> emp =dao.findAllByMap(map);
		System.out.println("result: "+emp);
	}
	
	
	@Test
	public void findName(){
		String config = "applicationContext.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		EmployeeDAO dao =(EmployeeDAO)ac.getBean("employeeDAO",EmployeeDAO.class);
		Map<String,Object> map=dao.findName();
		System.out.println(map);
	}
	
	
}