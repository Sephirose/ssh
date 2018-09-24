package cn.tedu.ems.entity;

import java.io.Serializable;
/**
 * 	包装类型(比如 Integer)，可以有null值，
 *  用来与数据库中的null值对应。
 *	
 */
public class Employee 
		implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6175729845521026752L;
	private Integer id;
	private String name;
	private Double salary;
	private Integer age;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	
	
	
	
}







