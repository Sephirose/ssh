package cn.tedu.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ems.entity.Employee;


public interface EmployeeDAO {
	public void save(Employee e);
	public List<Employee> findAll(@Param("start")Integer start,@Param("end")Integer end);
	public Integer findAllNum();
	public Employee findById(int id);
	public void modify(Employee e);
	public void delete(int id);
	
}






