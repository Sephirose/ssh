package cn.tedu.ems.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ems.entity.Employee;


public interface EmployeeDAO {
	public void save(Employee e);
	public List<Employee> findAll(@Param("start")Integer start,@Param("end")Integer end);
	public Integer findAllNum();
	public Employee findById(int id);
	public void modify(Employee e);
	public void delete(int id);
	public List<Employee> findAllByMap(Map<String, Object> map);
	public void addUnitPower(Map<String, Object> map);
	public Map<String,Object> findName();
	
}






